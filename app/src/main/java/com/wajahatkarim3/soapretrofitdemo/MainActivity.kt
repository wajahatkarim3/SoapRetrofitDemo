package com.wajahatkarim3.soapretrofitdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.wajahatkarim3.soapretrofitdemo.base.BaseActivity
import com.wajahatkarim3.soapretrofitdemo.base.BaseActivity_MembersInjector
import com.wajahatkarim3.soapretrofitdemo.networking.HolidaysForYear.ArrayOfHoliday
import com.wajahatkarim3.soapretrofitdemo.networking.HolidaysService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnCallService).setOnClickListener {
            loadCountriesAvailableList()
        }

    }

    fun loadCountriesAvailableList()
    {
        //showProgress("Loading Countries...")
        var call = retrofit.create(HolidaysService::class.java).getHolidaysForYear("Canada", "2018")
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
}
