package com.wajahatkarim3.soapretrofitdemo.screens.home

import android.content.Context
import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel
import com.wajahatkarim3.soapretrofitdemo.networking.responses.ArrayOfCountryCode
import com.wajahatkarim3.soapretrofitdemo.utils.getHolidaysAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class HomeRepository(val retrofit: Retrofit, val context: Context) : HomeContract.Repository {

}