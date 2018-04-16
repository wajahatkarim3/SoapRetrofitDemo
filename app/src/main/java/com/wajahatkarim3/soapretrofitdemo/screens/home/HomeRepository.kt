package com.wajahatkarim3.soapretrofitdemo.screens.home

import android.content.Context
import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel
import com.wajahatkarim3.soapretrofitdemo.models.HolidayModel
import com.wajahatkarim3.soapretrofitdemo.networking.responses.ArrayOfCountryCode
import com.wajahatkarim3.soapretrofitdemo.networking.responses.ArrayOfHoliday
import com.wajahatkarim3.soapretrofitdemo.utils.getHolidaysAPI
import org.joda.time.DateTime
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class HomeRepository(val retrofit: Retrofit, val context: Context) : HomeContract.Repository {

    override fun fetchHolidayDatesFromRemote(success: (holidaysList: List<HolidayModel>) -> Unit, error: (message: String) -> Unit) {
        var date = DateTime()

        var call = getHolidaysAPI(retrofit).getHolidaysForYear("UnitedStates", date.year.toString())
        call.enqueue(object : Callback<ArrayOfHoliday>{
            override fun onFailure(call: Call<ArrayOfHoliday>?, t: Throwable?) {
                error.invoke(t?.localizedMessage ?: "Unknown Error Occured")
            }

            override fun onResponse(call: Call<ArrayOfHoliday>?, response: Response<ArrayOfHoliday>?) {
                success.invoke(response?.body()?.holidaysList ?: emptyList())
            }
        })
    }

}