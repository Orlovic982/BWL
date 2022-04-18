package com.bridgewaterlabs.news.api

import com.bridgewaterlabs.news.BuildConfig
import com.bridgewaterlabs.news.util.Constant.Companion.BASE_URL
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInstance {

companion object{


    fun getMoshi():Moshi{
        return Moshi.Builder().build()
    }
    fun getRetrofitInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().also { client ->
                if(BuildConfig.DEBUG){
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)}
            }.build())
             .addConverterFactory(MoshiConverterFactory.create(getMoshi()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }


    fun getPublicApi():PublicApi{
        return  getRetrofitInstance().create(PublicApi::class.java)
    }
}
}
