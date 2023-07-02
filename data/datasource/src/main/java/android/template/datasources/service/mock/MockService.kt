package android.template.datasources.service.mock

import android.template.datasources.apimodels.ProductApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.random.Random

internal object MockService {

    // TODO: Read data from the "data.json" file
    fun getData(): Flow<List<ProductApiModel>> {
        return flow {
            var index = 0
            Thread.sleep(5_000)
            repeat(10) {
                Thread.sleep(2_000)
                emit(
                    List(5) {
                        index++
                        ProductApiModel(
                            id = it,
                            name = "Product $index",
                            price = Random.nextDouble(),
                        )
                    },
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}
