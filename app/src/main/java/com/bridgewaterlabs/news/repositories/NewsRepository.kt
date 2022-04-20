package com.bridgewaterlabs.news.repositories

import com.bridgewaterlabs.news.api.RetrofitInstance
import com.bridgewaterlabs.news.model.NewsResponse
import io.reactivex.rxjava3.core.Flowable

class NewsRepository {
    fun getNewsdetails(number: Int): Flowable<NewsResponse> {
        return RetrofitInstance.getPublicApi().getNewsDetails(number)
    }
}
