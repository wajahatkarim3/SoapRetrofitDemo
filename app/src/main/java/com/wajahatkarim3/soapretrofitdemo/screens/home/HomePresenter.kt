package com.wajahatkarim3.soapretrofitdemo.screens.home

import com.prolificinteractive.materialcalendarview.CalendarDay
import com.wajahatkarim3.soapretrofitdemo.base.BasePresenter
import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel
import com.wajahatkarim3.soapretrofitdemo.utils.toCalendarDay
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class HomePresenter(view: HomeContract.View, repo: HomeContract.Repository) : BasePresenter<HomeContract.View>(view), HomeContract.Actions {

    val repository = repo

    override fun initScreen() {
        _view?.setupViews()
        loadHolidayDates()
    }

    override fun loadHolidayDates() {
        _view?.showLoading("Loading holidays...")
        repository?.fetchHolidayDatesFromRemote(success = { holidaysList ->

                var list = ArrayList<CalendarDay>()

                for (holiday in holidaysList)
                {
                    var datestr = "2018-01-01T00:00:00"
                    datestr = holiday.Date ?: "2018-01-01T00:00:00"
                    datestr = datestr.substring(0, datestr.indexOf("T"))
                    var datetime = DateTime.parse(datestr, DateTimeFormat.forPattern("yyyy-MM-dd"))

                    list.add(datetime.toCalendarDay())
                }

                _view?.updateDates(list)

            },
            error = {
                _view?.hideLoading()
            })
    }
}

