package android.template.di

import android.template.api.httpClient.createKtorHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { createKtorHttpClient() }
}
