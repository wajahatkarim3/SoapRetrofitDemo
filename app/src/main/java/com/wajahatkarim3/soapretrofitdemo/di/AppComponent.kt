package com.wajahatkarim3.soapretrofitdemo.di

import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.wajahatkarim3.soapretrofitdemo.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {

    fun inject(app: Application)
    fun inject(act: BaseActivity)

}