package android.template.di

import android.template.api.apimodels.BASE_CAT_URL
import android.template.api.apimodels.rickandmorty.RICK_AND_MORTY_BASE_URL
import android.template.api.interceptors.getCatLocalInterceptor
import android.template.api.retrofit.NetworkClient
import android.template.api.retrofit.CatNetworkClient
import android.template.api.retrofit.RickAndMortyNetworkClient
import org.koin.dsl.module

val networkModule = module {
    single<NetworkClient> {
        CatNetworkClient(
            baseUrl = BASE_CAT_URL,
            localInterceptor = getCatLocalInterceptor(),
        )
    }
    single<NetworkClient> {
        RickAndMortyNetworkClient(
            baseUrl = RICK_AND_MORTY_BASE_URL,
        )
    }
}
