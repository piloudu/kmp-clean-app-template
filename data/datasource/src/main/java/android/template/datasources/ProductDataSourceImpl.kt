package android.template.datasources

import android.template.api.apimodels.ProductApiModel
import android.template.api.mock.MockService
import kotlinx.coroutines.flow.Flow

internal class ProductDataSourceImpl : ProductDataSource {

    override fun getProductsList(): Flow<List<ProductApiModel>> {
        return MockService.getProductsList()
    }

    override fun setProducts(products: List<ProductApiModel>) {
        MockService.setProductsList(products)
    }
}
