package android.template.api.mock

import android.template.api.apimodels.ProductApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.random.Random

internal object MockService {

    private var productsList: List<ProductApiModel> = emptyList()

    // TODO: Read data from the "data.json" file
    fun getProductsList(): Flow<List<ProductApiModel>> {
        return flow {
            var index = 0
            Thread.sleep(5_000)
            repeat(10) {
                Thread.sleep(2_000)
                productsList = List(5) {
                    index++
                    ProductApiModel(
                        id = it,
                        name = "Product $index",
                        price = Random.nextDouble(),
                    )
                }
            }
            emit(productsList)
        }.flowOn(Dispatchers.IO)
    }

    fun setProductsList(products: List<ProductApiModel>) {
        productsList = products
    }
}
