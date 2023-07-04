package android.template.di

import android.template.api.apimodels.BASE_CAT_URL
import android.template.api.interceptors.getCatLocalInterceptor
import android.template.api.retrofit.NetworkClient
import android.template.api.retrofit.NetworkClientImpl
import org.koin.dsl.module

val networkModule = module {
    single<NetworkClient> {
        NetworkClientImpl(
            baseUrl = BASE_CAT_URL,
            localInterceptor = getCatLocalInterceptor(),
        )
    }
}

val fakeNetworkModule = module {
    single<NetworkClient> {
        NetworkClientImpl(
            baseUrl = BASE_CAT_URL,
            localInterceptor = getCatLocalInterceptor(),
        )
    }
}
