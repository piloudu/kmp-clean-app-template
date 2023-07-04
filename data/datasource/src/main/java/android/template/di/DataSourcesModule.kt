package android.template.di

import android.template.datasources.CatDataSource
import android.template.datasources.CatDataSourceImpl
import android.template.datasources.FakeCatDatasource
import android.template.datasources.FakeProductsDatasource
import android.template.datasources.ProductDataSource
import android.template.datasources.ProductDataSourceImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourcesModule: Module = module {
    factoryOf(::ProductDataSourceImpl) bind ProductDataSource::class
    factoryOf(::CatDataSourceImpl) bind CatDataSource::class
}

fun getFakeDatasourceModule(isSuccess: Boolean): Module = module {
    factory<ProductDataSource> { FakeProductsDatasource(isSuccess) }
    factory<CatDataSource> { FakeCatDatasource(isSuccess) }
}
