package com.wajahatkarim3.soapretrofitdemo.di

import android.app.Application
import android.content.Context
import com.wajahatkarim3.soapretrofitdemo.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application)
{
    /*
     * Allow the app context to be inject(provided) but require
     * that it be annotated with [][ForAppQualifier] to explicitly
     * differentiate it from an activity context
     */
    @Provides
    @Singleton
    @ForAppQualifier
    fun provideAppContext() : Context = app

    @Provides
    @Singleton
    fun provideApplication() : MyApp = app as MyApp


}