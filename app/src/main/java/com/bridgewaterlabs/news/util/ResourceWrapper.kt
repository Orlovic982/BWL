package com.bridgewaterlabs.news.util

import android.app.Application

class ResourceWrapper(private val application: Application) {

    fun getString(resId: Int): String {
        return application.getString(resId)
    }

    fun getString(resId: Int, vararg formatArgs: Any): String {
        return application.getString(resId, *formatArgs)
    }
}
