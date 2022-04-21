package com.bridgewaterlabs.news.repositories

import com.bridgewaterlabs.news.api.RetrofitInstance
import com.bridgewaterlabs.news.model.Auth
import com.bridgewaterlabs.news.model.User
import com.bridgewaterlabs.news.model.requests.LoginRequset
import com.bridgewaterlabs.news.preferences.AuthPreferences
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable

class AuthRepository(
    private val authPreferences: AuthPreferences,
) {

    fun login(email: String, password: String): Flowable<Auth> {
        return RetrofitInstance.getPublicApi().login(
            LoginRequset(email = email, password = password)
        ).observeOn(AndroidSchedulers.mainThread()).doOnNext {
            authPreferences.token = it.access_token
        }
    }

    fun getProfile(): Flowable<User> {
        return RetrofitInstance.getPublicApi().getmyProfile()
    }
}
