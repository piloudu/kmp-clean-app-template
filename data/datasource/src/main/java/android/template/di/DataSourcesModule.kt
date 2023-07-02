package android.template.di

import android.template.api.apimodels.BASE_CAT_URL
import android.template.api.interceptors.getCatLocalInterceptor
import android.template.api.retrofit.NetworkClient
import android.template.datasources.CatDataSource
import android.template.datasources.CatDataSourceImpl
import android.template.datasources.ProductDataSource
import android.template.datasources.ProductDataSourceImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourcesModule: Module = module {
    factoryOf(::ProductDataSourceImpl) bind ProductDataSource::class
    factoryOf(::CatDataSourceImpl) bind CatDataSource::class
    single {
        NetworkClient(
            baseUrl = BASE_CAT_URL,
            localInterceptor = getCatLocalInterceptor(),
        )
    }
}
