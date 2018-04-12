package com.wajahatkarim3.soapretrofitdemo.base

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.wajahatkarim3.soapretrofitdemo.MyApp
import com.wajahatkarim3.soapretrofitdemo.R
import retrofit2.Retrofit
import javax.inject.Inject

class BaseActivity : AppCompatActivity() {

    @Inject lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        MyApp.appComponent.inject(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        if (item.itemId == android.R.id.home) {
            val currentapiVersion = Build.VERSION.SDK_INT
            if (currentapiVersion >= Build.VERSION_CODES.LOLLIPOP) {
                supportFinishAfterTransition()
            } else {
                finish()
            }
            return true
        }
        return false
    }

    // Kotlin Extension Methods
    fun BaseActivity.getApp() : MyApp = application as MyApp



}
