package android.template.datasources

import android.template.datasources.apimodels.ProductApiModel
import android.template.datasources.service.Service
import kotlinx.coroutines.flow.Flow

internal class ProductDataSourceImpl : ProductDataSource {
    override suspend fun getData(): Flow<ProductApiModel> {
        return Service.getData()
    }
}
