package android.template.datasources

import android.template.api.retrofit.NetworkClient
import android.template.api.service.CatService
import android.template.apimodels.CatApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class CatDataSourceImpl(
    networkClient: NetworkClient,
) : CatDataSource {
    val service = networkClient.retrofit.create(CatService::class.java)
    
    override fun getCat(): Flow<CatApiModel> {
        return flow { 
            service.getCat()
        }
    }
}
