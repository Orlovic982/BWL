package com.bridgewaterlabs.news.ui.onboarding.login

import retrofit2.HttpException

class ErrorLogin(private val throwable: Throwable) {
    val message: String
        get() {
            return when (throwable) {
                is HttpException -> "${throwable.code()} Message ${throwable.code()} "

                else -> { "Invalid mail or password" }
            }
        }
}
