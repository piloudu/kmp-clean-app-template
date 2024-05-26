package android.template.data

import android.template.api.apimodels.ProductApiModel
import android.template.datasources.ProductDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class FakeDataSource : ProductDataSource {

    private var internalProductsList: List<ProductApiModel> = productsList

    override fun getProductsList(): Flow<List<ProductApiModel>> {
        return flowOf(internalProductsList)
    }

    override fun setProducts(products: List<ProductApiModel>) {
        internalProductsList = products
    }
}

internal val productsList = listOf(
    ProductApiModel(
        id = 1111,
        name = "Product 1",
        price = 112.45,
    ),
    ProductApiModel(
        id = 2222,
        name = "Product 2",
        price = 2934.11,
    ),
)
