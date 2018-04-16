package com.wajahatkarim3.soapretrofitdemo.custom

import android.graphics.Color
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.spans.DotSpan
import com.wajahatkarim3.soapretrofitdemo.models.HolidayModel
import com.wajahatkarim3.soapretrofitdemo.utils.toJodaDate

class EventDecortor : DayViewDecorator
{
    var color = Color.parseColor("#E2A45C")
    var dates: HashMap<String, List<HolidayModel>>? = null

    constructor(color: Int, dates: HashMap<String, ArrayList<HolidayModel>>)
    {
        this.color = color
        this.dates = HashMap(dates)
    }

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        var datetime = day?.toJodaDate()
        return dates?.containsKey(datetime?.toString("yyyy-MM-dd")) ?: false
    }

    override fun decorate(view: DayViewFacade?) {
        view?.addSpan(DotSpan(7f, color))
    }
}
