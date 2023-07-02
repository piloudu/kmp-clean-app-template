package android.template.datasources.di

import android.template.datasources.ProductDataSource
import android.template.datasources.ProductDataSourceImpl
import android.template.datasources.service.retrofit.NetworkClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourcesModule: Module = module {
    factoryOf(::ProductDataSourceImpl) bind ProductDataSource::class
    single { NetworkClient("https://dog.ceo/api/breeds/image/") }
}
