package com.bridgewaterlabs.news.di

import com.bridgewaterlabs.news.ui.onboarding.login.ErrorLogin
import com.bridgewaterlabs.news.util.ResourceWrapper
import org.koin.dsl.module

val validationModule = module {
    single { ErrorLogin(get()) }
    single { ResourceWrapper(get()) }
}
