package com.wajahatkarim3.soapretrofitdemo.screens.home

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.thetechnocafe.gurleensethi.liteutils.RecyclerAdapterUtil
import com.wajahatkarim3.soapretrofitdemo.R
import com.wajahatkarim3.soapretrofitdemo.base.BaseActivity
import com.wajahatkarim3.soapretrofitdemo.custom.CurrentDateDecorator
import com.wajahatkarim3.soapretrofitdemo.custom.EventDecortor
import com.wajahatkarim3.soapretrofitdemo.custom.TodayDecorator
import com.wajahatkarim3.soapretrofitdemo.databinding.ActivityHomeBinding
import com.wajahatkarim3.soapretrofitdemo.databinding.HolidayEventItemLayoutBinding
import com.wajahatkarim3.soapretrofitdemo.models.HolidayModel
import com.wajahatkarim3.soapretrofitdemo.utils.toCalendarDay
import com.wajahatkarim3.soapretrofitdemo.utils.toJodaDate
import org.joda.time.DateTime
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import android.support.v4.view.ViewCompat.setTranslationY
import android.opengl.ETC1.getHeight
import android.support.v4.view.ViewCompat.animate
import android.R.string.cancel
import android.support.v4.view.ViewCompat.getTranslationY



class HomeActivity : BaseActivity(), HomeContract.View {

    lateinit var bi: ActivityHomeBinding
    lateinit var presenter: HomePresenter
    lateinit var repository: HomeContract.Repository
    var scrollY = 0

    val dayHolidaysList = ArrayList<HolidayModel>()
    var recyclerAdapter: RecyclerAdapterUtil<HolidayModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_home)

        repository = HomeRepository(retrofit, this)
        presenter = HomePresenter(this, repository)
        bi.view = this
        bi.presenter = presenter
        presenter.initScreen()
    }

    override fun setupViews() {
        // Month Year Headings
        setMonthYearHeading(DateTime())

        // Calendar
        bi.calendarView.topbarVisible = false
        bi.calendarView.showOtherDates = MaterialCalendarView.SHOW_DEFAULTS
        bi.calendarView.addDecorator(CurrentDateDecorator(this))
        bi.calendarView.setDateTextAppearance(R.style.TodayTextAppearance)

        // Today
        bi.txtDateSelected.text = DateTime().toString("EEEE, MMMM dd")

        // Calendar Listeners
        bi.calendarView.setOnMonthChangedListener { widget, date ->
            var dd = DateTime(date.date)
            dd = dd.plusMonths(1)
            setMonthYearHeading(dd)
        }
        bi.calendarView.setOnDateChangedListener { widget, date, selected ->
            selectDate(date)
        }

        // Recycler View
        recyclerAdapter = RecyclerAdapterUtil(this, dayHolidaysList, R.layout.holiday_event_item_layout)
        recyclerAdapter?.addOnDataBindListener { itemView, item, position, innerViews ->
            var bbb = DataBindingUtil.bind<HolidayEventItemLayoutBinding>(itemView)
            bbb?.holiday = item
            bbb?.executePendingBindings()
        }
        var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        bi.recyclerEvents.layoutManager = layoutManager
        bi.recyclerEvents.addItemDecoration(DividerItemDecoration(bi.recyclerEvents.context, layoutManager.orientation))
        bi.recyclerEvents.adapter = recyclerAdapter

    }

    fun changeToWeekMode()
    {
        bi.calendarView.state().edit()
                .setCalendarDisplayMode(CalendarMode.WEEKS)
                .commit()
    }

    fun changeToMonthsMode()
    {
        bi.calendarView.state().edit()
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit()
    }

    override fun selectDate(date: CalendarDay) {
        var datetime = date.toJodaDate()
        bi.txtDateSelected.text = datetime.toString("EEEE, MMMM dd")
        bi.calendarView.selectedDate = datetime.toCalendarDay()

        var ll = presenter.getEventsForDate(date)
        dayHolidaysList.clear()
        dayHolidaysList.addAll(ll)
        recyclerAdapter?.notifyDataSetChanged()
        for (eve in ll)
        {
            Log.w("HOLIDAY", eve.Descriptor)
        }
    }

    override fun showLoading(message: String) {
        showProgress(message)
    }

    override fun hideLoading() {
        hideProgress()
    }

    override fun setMonthYearHeading(date: DateTime) {
        bi.txtMonth.text = date.toString("MMMM")
        bi.txtYear.text = date.toString("YYYY")
        bi.txtDateSelected.text = date.toString("MMMM yyyy")

    }

    override fun updateDates(list: HashMap<String, ArrayList<HolidayModel>>) {
        hideLoading()
        bi.calendarView.addDecorator(EventDecortor(Color.RED, list))
        bi.calendarView.invalidateDecorators()
    }

}
