package android.template.datasources.service

import android.template.datasources.apimodels.ProductApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

internal object Service {

    // TODO: Read data from the "data.json" file
    suspend fun getData(): Flow<ProductApiModel> {
        return withContext(Dispatchers.IO) {
            flow {
                Thread.sleep(2000)
                emit(
                    ProductApiModel(
                        id = 1,
                        name = "Product 1",
                        price = 234.56,
                    )
                )
            }
        }
    }
}