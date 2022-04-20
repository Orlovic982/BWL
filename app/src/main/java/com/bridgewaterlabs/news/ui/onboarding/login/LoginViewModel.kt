package com.bridgewaterlabs.news.ui.onboarding.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bridgewaterlabs.news.repositories.AuthRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class LoginViewModel() : ViewModel() {
    val email = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val successLogin = MutableLiveData<Boolean>(false)
    val failureLogin = MutableLiveData<Boolean>(false)
    private val authRepository = AuthRepository()

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
                Log.d(
                    "Milan",
                    "Logovao si sledece podatke $email i {$password i dobio token:${it.access_token}"
                )
                successLogin.value = true
            },
            {
                failureLogin.value = true
            },
        )
        compositeDisposable.add(disposable)
    }
}
