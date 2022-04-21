package com.bridgewaterlabs.news.repositories

import com.bridgewaterlabs.news.api.RetrofitInstance
import com.bridgewaterlabs.news.model.NewsResponse
import com.bridgewaterlabs.news.preferences.AuthPreferences
import io.reactivex.rxjava3.core.Flowable

class NewsRepository(
    private val authPreferences: AuthPreferences,
) {
    fun getNewsdetails(number: Int): Flowable<NewsResponse> {
        authPreferences.token
        return RetrofitInstance.getPublicApi().getNewsDetails(number+1)
    }
}
