package com.bridgewaterlabs.news.ui.onboarding.login

import retrofit2.HttpException
import java.io.IOException

class ErrorLogin(private val throwable: Throwable) {
    val message: String
        get() {
            return when (throwable) {
                is HttpException ->
                    if (throwable.code() == 401) {
                        return "Invalid username or password."
                    } else {
                        return "Something went wrong. Code: ${throwable.code()} "
                    }
                is NoInternetException->"Please check your internet connection"
                else -> "Ups.Something went wrong"
            }
        }
}

class NoInternetException : IOException()
