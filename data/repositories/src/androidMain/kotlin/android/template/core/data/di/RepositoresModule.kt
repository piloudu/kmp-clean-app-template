package android.template.core.data.di

import android.template.core.data.repositories.CatRepositoryImpl
import android.template.core.data.repositories.ProductsRepositoryImpl
import android.template.domain.repositories.CatRepository
import android.template.domain.repositories.ProductsRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoriesModule: Module = module {
    factoryOf(::ProductsRepositoryImpl) bind ProductsRepository::class
    factoryOf(::CatRepositoryImpl) bind CatRepository::class
}
