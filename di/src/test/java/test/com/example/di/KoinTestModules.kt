package test.com.example.di

import android.template.core.data.di.dataModule
import android.template.core.database.di.databaseModule
import android.template.di.dataSourcesModule
import android.template.di.fakeNetworkModule
import android.template.domain.di.useCasesModule
import android.template.feature.main.di.featureMainModule
import org.koin.core.module.Module

val koinTestModules: List<Module> = listOf(
    dataModule,
    featureMainModule,
    databaseModule,
    dataSourcesModule,
    useCasesModule,
    fakeNetworkModule,
)
