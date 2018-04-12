package com.wajahatkarim3.soapretrofitdemo

import android.app.Application
import com.facebook.stetho.Stetho
import com.wajahatkarim3.soapretrofitdemo.di.AppComponent
import com.wajahatkarim3.soapretrofitdemo.di.AppModule
import com.wajahatkarim3.soapretrofitdemo.di.DaggerAppComponent
import com.wajahatkarim3.soapretrofitdemo.di.NetModule
import com.wajahatkarim3.soapretrofitdemo.utils.AppConstants

class MyApp : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        initDependencies()

    }

    fun initDependencies()
    {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(AppConstants.HTTP.BASE_URL))
                .build()

        appComponent.inject(this)
    }
}