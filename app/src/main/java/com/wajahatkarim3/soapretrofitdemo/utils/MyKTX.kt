package com.wajahatkarim3.soapretrofitdemo.utils

import com.wajahatkarim3.soapretrofitdemo.networking.HolidaysService
import retrofit2.Retrofit


fun <T> Any.createService(retrofit: Retrofit, service: Class<T>): T {
    return retrofit.create(service)
}

fun Any.getHolidaysAPI(retrofit: Retrofit) : HolidaysService
{
    return retrofit.create(HolidaysService::class.java)
}