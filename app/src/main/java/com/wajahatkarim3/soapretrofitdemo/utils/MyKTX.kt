package com.wajahatkarim3.soapretrofitdemo.utils

import retrofit2.Retrofit


fun <T> Any.createService(retrofit: Retrofit, service: Class<T>): T {
    return retrofit.create(service)
}