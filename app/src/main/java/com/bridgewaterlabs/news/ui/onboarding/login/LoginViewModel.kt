package com.bridgewaterlabs.news.ui.onboarding.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bridgewaterlabs.news.api.PublicApi
import com.bridgewaterlabs.news.repositories.AuthRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class LoginViewModel(private val authRepository: AuthRepository, private val publicApi: PublicApi) :
    ViewModel() {

    val email = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun login() {
        val flow = authRepository
            .loginApiCall(email.toString(), password.toString())
            .observeOn(AndroidSchedulers.mainThread())

        val disposable = flow.subscribe(
            {
                Log.d("Milan", "Logova si sledece podatke $email i $password i dobio token:${it.access_token}")

            },
            {

            },
        )
        compositeDisposable.add(disposable)
    }

}
