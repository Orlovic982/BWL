package com.bridgewaterlabs.news.ui.onboarding.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bridgewaterlabs.news.preferences.AuthPreferences
import com.bridgewaterlabs.news.repositories.AuthRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.HttpException

class LoginViewModel(
    private val preferences: AuthPreferences,
    private val authRepository: AuthRepository
) : ViewModel() {
    val email = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val errorLogin = MutableLiveData<String>()
      val loginState = MutableLiveData<LoginState>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


    fun login(email: String, password: String) {
        val flow = authRepository
            .login(email, password)
            .observeOn(AndroidSchedulers.mainThread())

        val disposable = flow.subscribe(
            {
                loginState.value = LoginState.Success
            },
            {
                val error = ErrorLogin(it)
                errorLogin.value=error.message

            }

    )
    compositeDisposable.add(disposable)
}
}
