package com.bridgewaterlabs.news

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDependencies()
    }

    private fun initDependencies() {
        startKoin {
            androidContext(this@App)
            modules(
                // modules
            )
        }
    }
}
