package com.bridgewaterlabs.news.model.requests

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class LoginRequset(
    val email: String,
    val password:String
)