package com.bridgewaterlabs.news.api

import com.bridgewaterlabs.news.model.Auth
import com.bridgewaterlabs.news.model.NewsResponse
import com.bridgewaterlabs.news.model.User
import com.bridgewaterlabs.news.model.requests.LoginRequset
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.*

interface PublicApi {

    @POST("login")
    fun login(
        @Body
        body: LoginRequset
    ): Flowable<Auth>

    @GET("my-profile")
    fun getmyProfile(
        @Header("Authorization") authorization: String = "Bearer 45|BBYeNe9zQReDhxegYdTMCUFQjwKoEME3vIxORbMS"
    ): Flowable<User>

    @POST("register")
    fun register(
        @Body
        body: User
    )

    @GET("news/{number}")
    fun getNewsDetails(
        @Path("number")
        number: Int
    ): Flowable<NewsResponse>
}
