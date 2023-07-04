package android.template.feature.main.ui

import android.template.domain.models.ProductModel
import android.template.domain.repositories.ProductsRepository
import android.template.feature.main.ui.products.productsException
import android.template.feature.main.ui.products.productsList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeProductsRepository(private val isSuccess: Boolean = true) : ProductsRepository {

    private var data: List<ProductModel> = emptyList()

    override fun getProductModels(): Flow<List<ProductModel>> {
        return flow {
            if (isSuccess) {
                emit(productsList)
            } else {
                throw productsException
            }
        }
    }

    override suspend fun setProductModel(productsList: List<ProductModel>) {
        data = productsList
    }
}
