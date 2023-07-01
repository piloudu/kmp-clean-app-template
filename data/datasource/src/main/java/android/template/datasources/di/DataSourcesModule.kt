package android.template.datasources.di

import android.template.datasources.ProductDataSource
import android.template.datasources.ProductDataSourceImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourcesModule: Module = module {
    factoryOf(::ProductDataSourceImpl) bind ProductDataSource::class
}
