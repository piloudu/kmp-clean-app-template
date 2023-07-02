package android.template.datasources

import android.template.api.mock.MockService
import android.template.api.apimodels.ProductApiModel
import kotlinx.coroutines.flow.Flow

internal class ProductDataSourceImpl : ProductDataSource {

    override fun getData(): Flow<List<ProductApiModel>> {
        return MockService.getData()
    }
}
