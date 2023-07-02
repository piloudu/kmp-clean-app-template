package android.template.domain.repositories

import android.template.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    fun getProductModels(): Flow<List<ProductModel>>

    suspend fun add(name: String)
}
