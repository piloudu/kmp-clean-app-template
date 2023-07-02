package android.template.core.data

import android.template.core.data.mappers.toDomainModel
import android.template.core.database.MyModel
import android.template.core.database.MyModelDao
import android.template.datasources.ProductDataSource
import android.template.datasources.apimodels.ProductApiModel
import android.template.domain.models.ProductModel
import android.template.domain.repositories.MyModelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class DefaultMyModelRepository(
    // TODO: Manage taking data from either datasource or database
    private val myModelDao: MyModelDao,
    private val productDataSource: ProductDataSource,
) : MyModelRepository {

    override fun getMyModels(): Flow<ProductModel> {
        return productDataSource.getData().map(ProductApiModel::toDomainModel)
    }

    override suspend fun add(name: String) {
        myModelDao.insertMyModel(MyModel(name = name))
    }
}
