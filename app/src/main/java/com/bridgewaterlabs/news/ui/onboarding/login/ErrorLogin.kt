package com.bridgewaterlabs.news.ui.onboarding.login

import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.util.ResourceWrapper
import retrofit2.HttpException
import java.io.IOException

class ErrorLogin(private val resource: ResourceWrapper) {


    private val noInternetConnection = resource.getString(R.string.check_internet_connection)
    private val usernameError = resource.getString(R.string.invalid_username_or_password)

    fun errorMessage(throwable: Throwable): String {
        return when (throwable) {
            is HttpException -> "${resource.getString(R.string.something_went_wrong)} Code:(${throwable.code()})"
            is NoInternetException -> resource.getString(R.string.check_internet_connection)
            else -> resource.getString(R.string.something_went_wrong)
        }
    }
}

class NoInternetException : IOException()
