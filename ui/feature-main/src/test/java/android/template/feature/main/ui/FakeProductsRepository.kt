package android.template.feature.main.ui

import android.template.domain.models.Price
import android.template.domain.models.ProductModel
import android.template.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeProductsRepository : ProductsRepository {

    private var data: List<ProductModel> = emptyList()

    override fun getProductModels(): Flow<List<ProductModel>> {
        return flowOf(productsList)
    }

    override suspend fun setProductModel(productsList: List<ProductModel>) {
        data = productsList
    }
}

internal val productsList = listOf(
    ProductModel(
        name = "Product 1",
        price = Price(112.45),
    ),
    ProductModel(
        name = "Product 2",
        price = Price(2934.11),
    ),
)
