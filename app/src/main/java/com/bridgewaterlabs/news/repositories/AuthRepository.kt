package com.bridgewaterlabs.news.repositories

import com.bridgewaterlabs.news.api.PublicApi
import com.bridgewaterlabs.news.api.RetrofitInstance
import com.bridgewaterlabs.news.model.Auth
import com.bridgewaterlabs.news.model.requests.LoginRequset

import io.reactivex.rxjava3.core.Flowable

class AuthRepository(private val publicApi: PublicApi) {


    fun loginApiCall(email: String, password: String): Flowable<Auth> {

        return RetrofitInstance.getPublicApi()
            .login(LoginRequset(email = email, password = password))
    }




}


