package com.wajahatkarim3.soapretrofitdemo.custom

import android.graphics.Color
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.spans.DotSpan

class EventDecortor : DayViewDecorator
{
    var color = Color.parseColor("#E2A45C")
    var dates: HashSet<CalendarDay>? = null

    constructor(color: Int, dates: HashSet<CalendarDay>)
    {
        this.color = color
        this.dates = HashSet(dates)
    }

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return dates?.contains(day) ?: false
    }

    override fun decorate(view: DayViewFacade?) {
        view?.addSpan(DotSpan(7f, color))
    }
}
