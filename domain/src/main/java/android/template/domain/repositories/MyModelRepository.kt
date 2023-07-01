package android.template.domain.repositories

import android.template.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface MyModelRepository {
    suspend fun getMyModels(): Flow<ProductModel>

    suspend fun add(name: String)
}
