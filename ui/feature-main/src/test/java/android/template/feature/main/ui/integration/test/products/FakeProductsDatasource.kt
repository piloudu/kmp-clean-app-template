package android.template.feature.main.ui.integration.test.products

import android.template.api.apimodels.ProductApiModel
import android.template.datasources.ProductDataSource
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
