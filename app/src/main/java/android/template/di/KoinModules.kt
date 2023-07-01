package android.template.di

import android.template.core.data.di.dataModule
import android.template.core.database.di.databaseModule
import android.template.datasources.di.dataSourcesModule
import android.template.domain.di.useCasesModule
import android.template.feature.mymodel.di.featureMyModelModule
import org.koin.core.module.Module

val koinModules: List<Module> = listOf(
    dataModule,
    featureMyModelModule,
    databaseModule,
    dataSourcesModule,
    useCasesModule,
)
