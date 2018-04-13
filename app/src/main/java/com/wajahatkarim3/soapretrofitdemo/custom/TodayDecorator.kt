package com.wajahatkarim3.soapretrofitdemo.custom

import android.content.Context
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.wajahatkarim3.soapretrofitdemo.R
import com.wajahatkarim3.soapretrofitdemo.utils.toJodaDate
import org.joda.time.DateTime

class TodayDecorator(val context: Context) : DayViewDecorator {

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        var today = DateTime().withTimeAtStartOfDay()
        var curDate = day?.toJodaDate()?.withTimeAtStartOfDay()
        return today.isEqual(curDate)
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(context.resources.getDrawable(R.drawable.today_circle_background))
        view?.setDaysDisabled(false)
    }
}