package android.template.di

import android.template.datasources.CatDataSource
import android.template.datasources.CatDataSourceImpl
import android.template.datasources.ProductDataSource
import android.template.datasources.ProductDataSourceImpl
import android.template.datasources.RickAndMortyDataSource
import android.template.datasources.RickAndMortyDataSourceImpl
import android.template.datasources.Test1DataSource
import android.template.datasources.Test1DataSourceImpl
import android.template.datasources.Test2DataSource
import android.template.datasources.Test2DataSourceImpl
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
    factoryOf(::Test1DataSourceImpl) bind Test1DataSource::class
    factoryOf(::Test2DataSourceImpl) bind Test2DataSource::class
}
