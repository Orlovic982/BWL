package com.bridgewaterlabs.news.ui.onboarding.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.preferences.AuthPreferences
import com.bridgewaterlabs.news.repositories.AuthRepository
import com.bridgewaterlabs.news.util.ResourceWrapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.HttpException



class LoginViewModel(
    private val preferences: AuthPreferences,
    private val authRepository: AuthRepository,
    private val errorLogin: ErrorLogin,
    private val resource: ResourceWrapper

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
                email.value = ""
                password.value = ""

                if ((it as? HttpException)?.code() == 401) {
                    loginState.value = LoginState.Error(resource.getString(R.string.invalid_username_or_password))
                } else {
                    val error = errorLogin.errorMessage(it)
                    loginState.value = LoginState.Error(error)
                }

                loginButton.value = true
            }

        )
        compositeDisposable.add(disposable)
    }
}
