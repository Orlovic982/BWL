package com.bridgewaterlabs.news.api

import com.bridgewaterlabs.news.model.Auth
import com.bridgewaterlabs.news.model.requests.LoginRequset
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.Body
import retrofit2.http.POST

interface PublicApi {
    @POST("login")
    fun login(
        @Body
        body: LoginRequset): Flowable<Auth>


}