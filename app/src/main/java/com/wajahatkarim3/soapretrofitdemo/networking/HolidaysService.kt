package com.wajahatkarim3.soapretrofitdemo.networking

import com.wajahatkarim3.soapretrofitdemo.networking.HolidaysForYear.ArrayOfHoliday
import retrofit2.Call
import retrofit2.http.*

interface HolidaysService
{
    /*
    @Headers(
        "Content-Type: text/xml",
        "Accept-Charset: utf-8"
    )
    @POST("GetHolidaysAvailable")
    fun getHolidaysAvailable(@Body body: RequestEnvelope) : Call<ResponseEnvelope>
    */

    /*
    @GET("GetHolidaysForYear")
    fun getHolidaysForYear(
            @Query("countryCode") countryCode: String,
            @Query("year") year: String
    ) : Call<String>
    */


    @GET("GetHolidaysForYear")
    fun getHolidaysForYear(
            @Query("countryCode") countryCode: String,
            @Query("year") year: String
    ) : Call<ArrayOfHoliday>

}