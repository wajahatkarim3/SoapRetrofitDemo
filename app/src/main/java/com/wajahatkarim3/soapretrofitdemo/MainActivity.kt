package com.wajahatkarim3.soapretrofitdemo

import android.os.Bundle
import android.widget.Button
import com.wajahatkarim3.soapretrofitdemo.base.BaseActivity
import com.wajahatkarim3.soapretrofitdemo.networking.responses.ArrayOfHoliday
import com.wajahatkarim3.soapretrofitdemo.networking.HolidaysService
import com.wajahatkarim3.soapretrofitdemo.networking.responses.ArrayOfCountryCode
import com.wajahatkarim3.soapretrofitdemo.networking.responses.ArrayOfHolidayCode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnCallService).setOnClickListener {
            loadAvailableCountries()
        }

    }

    fun loadHolidaysForYear()
    {
        //showProgress("Loading Countries...")
        var call = getHolidaysAPI().getHolidaysForYear("Canada", "2018")
        call.enqueue(object : Callback<ArrayOfHoliday>{
            override fun onFailure(call: Call<ArrayOfHoliday>?, t: Throwable?) {
                t?.printStackTrace()
                var i = 0
                i++
                i++
                i++
                i++
            }

            override fun onResponse(call: Call<ArrayOfHoliday>?, response: Response<ArrayOfHoliday>?) {
                var i = 0
                i++
                i++
                i++
                i++
            }

        })
    }

    fun loadHolidaysAvailableList()
    {
        var call = getHolidaysAPI().getHolidaysAvailable("Canada")
        call.enqueue(object : Callback<ArrayOfHolidayCode>{
            override fun onFailure(call: Call<ArrayOfHolidayCode>?, t: Throwable?) {
                t?.printStackTrace()
                var i = 0
                i++
                i++
                i++
                i++
            }

            override fun onResponse(call: Call<ArrayOfHolidayCode>?, response: Response<ArrayOfHolidayCode>?) {
                var i = 0
                i++
                i++
                i++
                i++
            }

        })
    }

    fun loadAvailableCountries()
    {
        var call = getHolidaysAPI().getCountriesAvailable()
        call.enqueue(object : Callback<ArrayOfCountryCode>{
            override fun onFailure(call: Call<ArrayOfCountryCode>?, t: Throwable?) {
                t?.printStackTrace()
                var i = 0
                i++
                i++
                i++
                i++
            }

            override fun onResponse(call: Call<ArrayOfCountryCode>?, response: Response<ArrayOfCountryCode>?) {
                var i = 0
                i++
                i++
                i++
                i++
            }

        })
    }
}
