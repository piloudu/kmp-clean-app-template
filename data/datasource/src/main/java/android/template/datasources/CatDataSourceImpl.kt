package android.template.datasources

import android.template.api.apimodels.CatApiModel
import android.template.api.retrofit.NetworkClient
import android.template.api.service.CatService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class CatDataSourceImpl(
    networkClient: NetworkClient,
) : CatDataSource {
    private val service = networkClient.retrofit.create(CatService::class.java)

    override fun getCatSequentially(): Flow<CatApiModel> {
        return flow {
            emit(service.getCat())
            while (true) {
                Thread.sleep(3000)
                emit(service.getCat())
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getCatsList(): Flow<List<CatApiModel>> {
        return flow {
            emit(
                List(15) {
                    service.getCat()
                },
            )
        }
    }
}
