package android.template.data

import android.template.core.database.ProductDao
import android.template.core.database.ProductDatabaseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class FakeProductDao : ProductDao {

    private val data = mutableListOf<ProductDatabaseModel>()

    override fun getProductModels(): Flow<List<ProductDatabaseModel>> = flow {
        emit(data)
    }

    override suspend fun insertProductModel(productsList: List<ProductDatabaseModel>) {
        data.addAll(productsList)
    }
}
