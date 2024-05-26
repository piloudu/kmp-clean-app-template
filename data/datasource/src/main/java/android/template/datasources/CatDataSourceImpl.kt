package android.template.datasources

import android.template.api.apimodels.CatApiModel
import android.template.api.service.getCat
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class CatDataSourceImpl(
    private val networkClient: HttpClient,
) : CatDataSource {
    override fun getCatSequentially(): Flow<CatApiModel> {
        return flow {
            emit(networkClient.getCat())
            while (true) {
                emit(networkClient.getCat())
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getCatsList(): Flow<List<CatApiModel>> {
        return flow {
            emit(
                List(15) {
                    networkClient.getCat()
                },
            )
        }
    }
}
