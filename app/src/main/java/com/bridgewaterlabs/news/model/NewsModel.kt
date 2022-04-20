package com.bridgewaterlabs.news.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsModel(
    val title: String,
    val body: String
)
