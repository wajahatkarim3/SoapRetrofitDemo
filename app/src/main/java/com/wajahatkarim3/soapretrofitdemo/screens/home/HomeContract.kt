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
        fun updateDates(list: ArrayList<CalendarDay>)
    }

    interface Actions {
        fun initScreen()
        fun loadHolidayDates()
    }

    interface Repository {
        fun fetchHolidayDatesFromRemote( success: (holidaysList: List<HolidayModel>) -> Unit, error: (message: String) -> Unit )
    }

}