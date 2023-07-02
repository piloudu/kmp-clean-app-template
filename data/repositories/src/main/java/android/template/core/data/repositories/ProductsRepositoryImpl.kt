package android.template.core.data.repositories

import android.template.api.apimodels.ProductApiModel
import android.template.core.data.mappers.toDomainModel
import android.template.core.database.ProductDao
import android.template.core.database.ProductDatabaseModel
import android.template.datasources.ProductDataSource
import android.template.domain.models.ProductModel
import android.template.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class ProductsRepositoryImpl(
    // TODO: Manage taking data from either datasource or database
    private val productDao: ProductDao,
    private val productDataSource: ProductDataSource,
) : ProductsRepository {

    override fun getProductModels(): Flow<List<ProductModel>> {
        return productDataSource.getData().map(List<ProductApiModel>::toDomainModel)
    }

    override suspend fun add(name: String) {
        productDao.insertProductModel(ProductDatabaseModel(name = name))
    }
}
