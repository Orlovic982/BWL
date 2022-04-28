package com.bridgewaterlabs.news.ui.onboarding.login
sealed class LoginState {
    data class Error(val message: String) : LoginState()
    data class EmailNotVerified(val email: String) : LoginState()
    object InvalidCredentials : LoginState()
    object Success : LoginState()
}
