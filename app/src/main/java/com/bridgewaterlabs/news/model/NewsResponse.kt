package com.bridgewaterlabs.news.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse(
    val news: News
)
