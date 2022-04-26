package com.bridgewaterlabs.news.ui.onboarding.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bridgewaterlabs.news.preferences.AuthPreferences
import com.bridgewaterlabs.news.repositories.AuthRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class LoginViewModel(
    private val preferences: AuthPreferences,
    private val authRepository: AuthRepository
) : ViewModel() {
    var email = MutableLiveData<String>("")
    var password = MutableLiveData<String>("")
    val loginButton = MutableLiveData<Boolean>(true)

    val loginState = MutableLiveData<LoginState>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun login(emailInput: String, passwordInput: String) {
        loginButton.value = false

        val flow = authRepository
            .login(emailInput, passwordInput)
            .observeOn(AndroidSchedulers.mainThread())

        val disposable = flow.subscribe(
            {
                loginState.value = LoginState.Success
            },
            {
                email.value=""
                password.value=""
                val error = ErrorLogin(it)
                loginState.value = LoginState.Error(error.message)
                loginButton.value = true
            }

        )
        compositeDisposable.add(disposable)
    }
}
