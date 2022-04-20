package com.bridgewaterlabs.news.api

import com.bridgewaterlabs.news.util.Constant.Companion.BASE_URL
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInstance {

    companion object {

        private fun getMoshi(): Moshi {
            return Moshi.Builder().build()
        }

        private fun getRetrofitInstance(): Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(MoshiConverterFactory.create(getMoshi()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }

        fun getPublicApi(): PublicApi {
            return getRetrofitInstance().create(PublicApi::class.java)
        }
    }
}
