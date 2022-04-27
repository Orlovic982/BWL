package com.bridgewaterlabs.news.di

import com.bridgewaterlabs.news.ui.main.home.HomeViewModel
import com.bridgewaterlabs.news.ui.main.newsdetails.NewsDetailsViewModel
import com.bridgewaterlabs.news.ui.onboarding.forgotpassword.ForgotPasswordViewModel
import com.bridgewaterlabs.news.ui.onboarding.login.LoginViewModel
import com.bridgewaterlabs.news.ui.onboarding.register.RegisterViewModel
import com.bridgewaterlabs.news.ui.onboarding.resetpassword.ResetPasswordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ForgotPasswordViewModel() }
    viewModel { RegisterViewModel() }
    viewModel { ResetPasswordViewModel() }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { LoginViewModel(get(), get(),get()) }
    viewModel { NewsDetailsViewModel() }
}
