package android.template.datasources

import android.template.api.apimodels.ProductApiModel
import kotlinx.coroutines.flow.Flow

interface ProductDataSource {
    fun getProductsList(): Flow<List<ProductApiModel>>
    fun setProducts(products: List<ProductApiModel>)
}
