package com.bridgewaterlabs.news.ui.main.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bridgewaterlabs.news.repositories.AuthRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class HomeViewModel() : ViewModel() {

    private val authRepository = AuthRepository()
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getProfile() {
        val flow = authRepository.getProfile()
            .observeOn(AndroidSchedulers.mainThread())

        val disposable = flow.subscribe(
            {
                Log.d(
                    "Milan",
                    " \nPodaci: \n Email: ${it.email} " +
                        "\n First name: ${it.first_name}" +
                        "\n Last name: ${it.last_name}"
                )
            },
            {
                Log.d(
                    "Milan",
                    "\n Odgovor: \n ${it.message} + ${it.cause} + ${it.stackTrace} + ${it.localizedMessage}"
                )
            }
        )
        compositeDisposable.add(disposable)
    }
}
