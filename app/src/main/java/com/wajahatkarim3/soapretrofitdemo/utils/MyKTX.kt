package com.wajahatkarim3.soapretrofitdemo.utils

import com.prolificinteractive.materialcalendarview.CalendarDay
import com.wajahatkarim3.soapretrofitdemo.networking.HolidaysService
import org.joda.time.DateTime
import retrofit2.Retrofit


fun <T> Any.createService(retrofit: Retrofit, service: Class<T>): T {
    return retrofit.create(service)
}

fun Any.getHolidaysAPI(retrofit: Retrofit) : HolidaysService
{
    return retrofit.create(HolidaysService::class.java)
}

fun CalendarDay.toJodaDate() : DateTime
{
    var dateTime = DateTime(this.date.time)
    dateTime = dateTime.plusDays(1)
    return dateTime
}

fun DateTime.toCalendarDay() : CalendarDay
{
    var day = CalendarDay.from(this.year, this.monthOfYear-1, this.dayOfMonth)
    return day
}