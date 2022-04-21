package com.bridgewaterlabs.news.di

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.bridgewaterlabs.news.preferences.AuthPreferences
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val SHARED_PREFERENCES_FILE: String = "encrypted_preferences"
private const val SHARED_PREFERENCES_ENCRYPTED = "encrypted"

val preferencesModule = module {
    single(named(SHARED_PREFERENCES_ENCRYPTED)) {
        EncryptedSharedPreferences.create(
            get(),
            SHARED_PREFERENCES_FILE,
            MasterKey.Builder(get()).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    single {
        AuthPreferences(get(named(SHARED_PREFERENCES_ENCRYPTED)))
    }

}
