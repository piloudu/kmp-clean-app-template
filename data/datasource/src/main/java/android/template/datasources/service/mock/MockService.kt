package android.template.datasources.service.mock

import android.template.datasources.apimodels.ProductApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal object MockService {

    // TODO: Read data from the "data.json" file
    fun getData(): Flow<List<ProductApiModel>> {
        return flow {
            Thread.sleep(10_000)
            emit(
                listOf(
                    ProductApiModel(
                        id = 1,
                        name = "Product 1",
                        price = 234.56,
                    ),
                ),
            )
        }.flowOn(Dispatchers.IO)
    }
}
