package com.bridgewaterlabs.news.ui.main.newsdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bridgewaterlabs.news.repositories.NewsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class NewsDetailsViewModel : ViewModel() {

    private val newsRepository = NewsRepository()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getNewsDetails(position: Int) {
        Log.d("Milan", "\n\nYou passed number $position here ")
        val flow = newsRepository
            .getNewsdetails(position)
            .observeOn(AndroidSchedulers.mainThread())

        val disposable = flow.subscribe(
            {
                Log.d(
                    "Milan",
                    "\n ${it.news.id} " +
                        "\n ${it.news.title} " +
                        "\n ${it.news.text} " +
                        "\n ${it.news.short_description} "
                )
            },
            {
                Log.d(
                    "Milan",
                    "Odgovor \n ${it.message} + \n ${it.cause} + \n ${it.stackTrace} + \n ${it.localizedMessage}"
                )
            },
        )
        compositeDisposable.add(disposable)
    }
}
