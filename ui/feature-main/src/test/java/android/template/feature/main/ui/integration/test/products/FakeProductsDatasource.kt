package android.template.feature.main.ui.integration.test.products

import android.template.api.apimodels.ProductApiModel
import android.template.datasources.ProductDataSource
import android.template.feature.main.ui.integration.test.di.TestCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeProductsDatasource(private val testCase: TestCase) : ProductDataSource {

    private var data: List<ProductApiModel> = emptyList()
    override fun getProductsList(): Flow<List<ProductApiModel>> {
        return flow {
            when (testCase) {
                TestCase.SUCCESS -> emit(productsList)
                TestCase.FAILURE -> throw productsException
            }
        }
    }

    override fun setProducts(products: List<ProductApiModel>) {
        data = productsList
    }
}
