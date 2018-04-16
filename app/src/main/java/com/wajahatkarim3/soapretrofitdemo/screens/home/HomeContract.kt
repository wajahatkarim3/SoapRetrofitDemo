package com.wajahatkarim3.soapretrofitdemo.screens.home

import com.prolificinteractive.materialcalendarview.CalendarDay
import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel
import com.wajahatkarim3.soapretrofitdemo.models.HolidayModel
import org.joda.time.DateTime

interface HomeContract {
    interface View {
        fun setupViews()
        fun showLoading(message: String)
        fun hideLoading()
        fun setMonthYearHeading(date: DateTime)
        fun selectDate(date: CalendarDay)
        fun updateDates(list: HashMap<String, ArrayList<HolidayModel>>)
    }

    interface Actions {
        fun initScreen()
        fun loadHolidayDates()
        fun getEventsForDate(date: CalendarDay) : List<HolidayModel>
    }

    interface Repository {
        fun fetchHolidayDatesFromRemote( success: (holidaysList: List<HolidayModel>) -> Unit, error: (message: String) -> Unit )
    }

}