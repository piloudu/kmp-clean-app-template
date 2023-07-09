package android.template.di

import android.template.datasources.CatDataSource
import android.template.datasources.CatDataSourceImpl
import android.template.datasources.ProductDataSource
import android.template.datasources.ProductDataSourceImpl
import android.template.datasources.RickAndMortyDataSource
import android.template.datasources.RickAndMortyDataSourceImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourcesModule: Module = module {
    factoryOf(::ProductDataSourceImpl) bind ProductDataSource::class
    factory<CatDataSource> {
        CatDataSourceImpl(networkClient = get(named(CAT_SCOPE_NAME)))
    }
    factory<RickAndMortyDataSource> {
        RickAndMortyDataSourceImpl(networkClient = get(named(RICK_AND_MORTY_SCOPE_NAME)))
    }
}
