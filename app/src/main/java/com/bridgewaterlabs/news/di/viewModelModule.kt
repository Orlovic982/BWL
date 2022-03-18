package com.bridgewaterlabs.news.di

import com.bridgewaterlabs.news.ui.onboarding.forgotpassword.ForgotPasswordViewModel
import com.bridgewaterlabs.news.ui.onboarding.register.RegisterViewModel
import com.bridgewaterlabs.news.ui.onboarding.resetpassword.ResetPasswordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ForgotPasswordViewModel() }
    viewModel { RegisterViewModel() }
    viewModel { ResetPasswordViewModel() }
}
