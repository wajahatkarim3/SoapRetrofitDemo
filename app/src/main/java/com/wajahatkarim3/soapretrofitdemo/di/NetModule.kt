package com.wajahatkarim3.soapretrofitdemo.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

@Module
class NetModule(val baseUrl: String)  {

    /*
    @Provides
    @Singleton
    fun provideHttpCache(application: Application) : Cache
    {
        var cacheSize: Long = 10 * 1024 * 1024
        var cache = Cache(application.cacheDir, cacheSize)
        return cache
    }
    */

    /*
    // We don't need GSON as we will use SimpleXML
    @Provides
    @Singleton
    fun provideGson() : Gson
    {
        var gsonBuilder = GsonBuilder()
        //gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }
    */

    @Provides
    @Singleton
    fun provideSimpleXML() : SimpleXmlConverterFactory
    {
        return SimpleXmlConverterFactory.create()
    }

    // OkHttp Client with Stetho Intereceptor
    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient
    {
        var client = OkHttpClient.Builder()
        //client.cache(cache)
        client.networkInterceptors().add(StethoInterceptor())
        return client.build()
    }

    /*
    // Retrofit with GSON
    // We Don't need in this case
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient) : Retrofit
    {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }
    */

    // Retrofit with SimpleXML
    @Provides
    @Singleton
    fun provideXmlRetrofit(xmlFactory: SimpleXmlConverterFactory, okHttpClient: OkHttpClient) : Retrofit
    {
        return Retrofit.Builder()
                .addConverterFactory(xmlFactory)
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }
}