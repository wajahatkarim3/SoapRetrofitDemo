package com.wajahatkarim3.soapretrofitdemo.networking

import com.wajahatkarim3.soapretrofitdemo.networking.responses.ArrayOfCountryCode
import com.wajahatkarim3.soapretrofitdemo.networking.responses.ArrayOfHoliday
import com.wajahatkarim3.soapretrofitdemo.networking.responses.ArrayOfHolidayCode
import retrofit2.Call
import retrofit2.http.*

interface HolidaysService
{

    @GET("GetCountriesAvailable")
    fun getCountriesAvailable() : Call<ArrayOfCountryCode>

    @GET("GetHolidaysAvailable")
    fun getHolidaysAvailable(
            @Query("countryCode") countryCode: String
    ) : Call<ArrayOfHolidayCode>


    @GET("GetHolidaysForYear")
    fun getHolidaysForYear(
            @Query("countryCode") countryCode: String,
            @Query("year") year: String
    ) : Call<ArrayOfHoliday>

    @GET("GetHolidaysForMonth")
    fun getHolidaysForMonth(
            @Query("countryCode") countryCode: String,
            @Query("year") year: String,
            @Query("month") month: String
    ) : Call<ArrayOfHoliday>
}