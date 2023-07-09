package android.template.core.data.di

import android.template.core.data.cache.RickAndMortyCache
import android.template.core.data.repositories.CatRepositoryImpl
import android.template.core.data.repositories.ProductsRepositoryImpl
import android.template.core.data.repositories.RickAndMortyRepositoryImpl
import android.template.domain.repositories.CatRepository
import android.template.domain.repositories.ProductsRepository
import android.template.domain.repositories.RickAndMortyRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoriesModule: Module = module {
    factoryOf(::ProductsRepositoryImpl) bind ProductsRepository::class
    factoryOf(::CatRepositoryImpl) bind CatRepository::class
    factoryOf(::RickAndMortyRepositoryImpl) bind RickAndMortyRepository::class
    singleOf(::RickAndMortyCache)
}
