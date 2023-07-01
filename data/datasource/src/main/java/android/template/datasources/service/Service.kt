package android.template.datasources.service

import android.template.datasources.apimodels.ProductApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal object Service {

    // TODO: Read data from the "data.json" file
    fun getData(): Flow<ProductApiModel> {
        return flow {
            Thread.sleep(10_000)
            emit(
                ProductApiModel(
                    id = 1,
                    name = "Product 1",
                    price = 234.56,
                ),
            )
        }.flowOn(Dispatchers.IO)
    }
}
