package com.bridgewaterlabs.news.preferences

import android.content.SharedPreferences

private const val KEY_TOKEN = "token"
private const val KEY_REFRESH_TOKEN = "refresh_token"

private const val KEY_CREATED_AT = "created_at"
private const val KEY_EMAIL = "email"
private const val KEY_EMAIL_VERIFIED_AT = "email_verified_at"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_ID = "id"
private const val KEY_IMAGE_URL = "image_url"
private const val KEY_LAST_NAME = "last_name"
private const val KEY_UPDATE_AT = "updated_at"

class AuthPreferences(
    private val preferences: SharedPreferences,
) {

    var token
        get() = preferences.getString(KEY_TOKEN, null)
        set(value) { preferences.edit().putString(KEY_TOKEN, value).apply() }

    var refreshToken
        get() = preferences.getString(KEY_REFRESH_TOKEN, null)
        set(value) = preferences.edit().putString(KEY_REFRESH_TOKEN, value).apply()
//
//    var user: User?
//        get() {
//            User(
//                email = preferences.getString(KEY_EMAIL, null),
//                created_at = preferences.getString(KEY_CREATED_AT, null),
//                first_name = preferences.getString(KEY_FIRST_NAME, null),
//                id = preferences.getInt(KEY_ID, 0),
//                image_url = preferences.getString(KEY_IMAGE_URL, null),
//                last_name = preferences.getString(KEY_LAST_NAME, null),
//                updated_at = preferences.getString(KEY_UPDATE_AT, null)
//            )
//        }
//        set(value) {}
//
}
