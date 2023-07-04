package android.template.datasources

import android.template.api.apimodels.ProductApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeProductsDatasource(private val isSuccess: Boolean) : ProductDataSource {

    private var data: List<ProductApiModel> = emptyList()
    override fun getProductsList(): Flow<List<ProductApiModel>> {
        return flow {
            if (isSuccess) {
                emit(productsList)
            } else {
                throw productsException
            }
        }
    }

    override fun setProducts(products: List<ProductApiModel>) {
        data = productsList
    }
}

internal val productsList = listOf(
    ProductApiModel(
        name = "Product 1",
        price = 112.45,
    ),
    ProductApiModel(
        name = "Product 2",
        price = 2934.11,
    ),
)

internal val productsException = Exception()
