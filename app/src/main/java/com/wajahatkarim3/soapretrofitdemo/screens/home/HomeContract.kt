package com.wajahatkarim3.soapretrofitdemo.screens.home

import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel

interface HomeContract {
    interface View {
        fun setupViews()
        fun showLoading(message: String)
        fun hideLoading()
    }

    interface Actions {
        fun initScreen()
    }

    interface Repository {

    }

}