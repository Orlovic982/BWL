package com.bridgewaterlabs.news

import android.app.Application
import com.bridgewaterlabs.news.di.preferencesModule
import com.bridgewaterlabs.news.di.repositoryModule
import com.bridgewaterlabs.news.di.validationModule
import com.bridgewaterlabs.news.di.viewModelModule
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
                viewModelModule,
                preferencesModule,
                repositoryModule,
                validationModule
            )
        }
    }
}
