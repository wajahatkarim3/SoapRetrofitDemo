package com.wajahatkarim3.soapretrofitdemo.screens.home

import com.prolificinteractive.materialcalendarview.CalendarDay
import com.wajahatkarim3.soapretrofitdemo.base.BasePresenter
import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel
import com.wajahatkarim3.soapretrofitdemo.models.HolidayModel
import com.wajahatkarim3.soapretrofitdemo.utils.toCalendarDay
import com.wajahatkarim3.soapretrofitdemo.utils.toDateKey
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class HomePresenter(view: HomeContract.View, repo: HomeContract.Repository) : BasePresenter<HomeContract.View>(view), HomeContract.Actions {

    val repository = repo

    var map = HashMap<String, ArrayList<HolidayModel>>()

    override fun initScreen() {
        _view?.setupViews()
        loadHolidayDates()
    }

    override fun getEventsForDate(date: CalendarDay): List<HolidayModel> {
        var list = ArrayList<HolidayModel>()
        list.addAll(map.get(date.toDateKey()) ?: emptyList())
        return list
    }

    override fun loadHolidayDates() {
        _view?.showLoading("Loading holidays...")
        repository?.fetchHolidayDatesFromRemote(success = { holidaysList ->

                map.clear()

                for (holiday in holidaysList)
                {
                    var datestr = "2018-01-01T00:00:00"
                    datestr = holiday.Date ?: "2018-01-01T00:00:00"
                    datestr = datestr.substring(0, datestr.indexOf("T"))
                    var datetime = DateTime.parse(datestr, DateTimeFormat.forPattern("yyyy-MM-dd"))


                    if (map.containsKey(datestr))
                    {
                        map.get(datestr)?.add(holiday)
                    }
                    else
                    {
                        var ll = ArrayList<HolidayModel>()
                        ll.add(holiday)
                        map.put(datestr, ll)
                    }
                }

                _view?.updateDates(map)

            },
            error = {
                _view?.hideLoading()
            })
    }
}

