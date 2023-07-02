package android.template.core.data.di

import android.template.core.data.DefaultMyModelRepository
import android.template.domain.models.Price
import android.template.domain.models.ProductModel
import android.template.domain.repositories.MyModelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule: Module = module {
    factoryOf(::DefaultMyModelRepository) bind MyModelRepository::class
}

class FakeMyModelRepository : MyModelRepository {
    override fun getMyModels(): Flow<ProductModel> {
        return flowOf(ProductModel(name = "", price = Price(value = null)))
    }

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}

val fakeMyModels = listOf("One", "Two", "Three")
