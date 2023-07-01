package android.template.datasources

import android.template.datasources.apimodels.ProductApiModel
import kotlinx.coroutines.flow.Flow

interface ProductDataSource {
    fun getData(): Flow<ProductApiModel>
}
