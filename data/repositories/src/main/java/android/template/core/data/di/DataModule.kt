package android.template.core.data.di

import android.template.core.data.repositories.CatRepositoryImpl
import android.template.core.data.repositories.ProductsRepositoryImpl
import android.template.domain.models.Price
import android.template.domain.models.ProductModel
import android.template.domain.repositories.CatRepository
import android.template.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule: Module = module {
    factoryOf(::ProductsRepositoryImpl) bind ProductsRepository::class
    factoryOf(::CatRepositoryImpl) bind CatRepository::class
}

class FakeProductsRepository : ProductsRepository {
    override fun getProductModels(): Flow<List<ProductModel>> {
        return flowOf(listOf(ProductModel(name = "", price = Price(value = null))))
    }

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}

val fakeMyModels = listOf("One", "Two", "Three")
