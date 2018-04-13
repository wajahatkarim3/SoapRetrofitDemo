package com.wajahatkarim3.soapretrofitdemo.screens.home

import com.wajahatkarim3.soapretrofitdemo.base.BasePresenter
import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel

class HomePresenter(view: HomeContract.View, repo: HomeContract.Repository) : BasePresenter<HomeContract.View>(view), HomeContract.Actions {

    val repository = repo

    override fun initScreen() {
        _view?.setupViews()
    }
}

