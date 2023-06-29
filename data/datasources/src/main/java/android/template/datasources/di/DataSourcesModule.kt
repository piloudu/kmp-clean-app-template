package android.template.datasources.di

import android.template.datasources.SampleDataSource
import android.template.datasources.SampleDataSourceImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourcesModule: Module = module {
    factoryOf(::SampleDataSourceImpl) bind SampleDataSource::class
}
