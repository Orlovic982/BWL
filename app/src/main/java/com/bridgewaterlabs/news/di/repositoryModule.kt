package com.bridgewaterlabs.news.di

import com.bridgewaterlabs.news.repositories.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AuthRepository() }
}
