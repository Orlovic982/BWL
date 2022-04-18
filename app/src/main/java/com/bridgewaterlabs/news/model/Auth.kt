package com.bridgewaterlabs.news.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Auth(
    val access_token: String,
    val user: User
)