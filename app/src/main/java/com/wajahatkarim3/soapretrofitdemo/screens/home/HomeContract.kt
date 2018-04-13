package com.wajahatkarim3.soapretrofitdemo.screens.home

import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel
import org.joda.time.DateTime

interface HomeContract {
    interface View {
        fun setupViews()
        fun showLoading(message: String)
        fun hideLoading()
        fun setMonthYearHeading(date: DateTime)
    }

    interface Actions {
        fun initScreen()
    }

    interface Repository {

    }

}