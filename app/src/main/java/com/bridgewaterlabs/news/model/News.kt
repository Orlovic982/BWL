package com.bridgewaterlabs.news.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class News(
    val created_at: String,
    val id: Int,
    val image_url: String,
    val short_description: String,
    val text: String,
    val title: String,
    val updated_at: String
)
