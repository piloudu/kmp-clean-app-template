package android.template.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import android.template.core.data.repositories.ProductsRepositoryImpl
import android.template.core.database.ProductDatabaseModel
import android.template.core.database.ProductDao

/**
 * Unit tests for [ProductsRepositoryImpl].
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultProductDatabaseModelRepositoryTest {

    @Test
    fun products_newItemSaved_itemIsReturned() = runTest {
        // TODO: Fix test
        val repository = ProductsRepositoryImpl(FakeProductDao())

        repository.add("Repository")

        assertEquals(repository.myModels.first().size, 1)
    }

}

private class FakeProductDao : ProductDao {

    private val data = mutableListOf<ProductDatabaseModel>()

    override fun getProductModels(): Flow<List<ProductDatabaseModel>> = flow {
        emit(data)
    }

    override suspend fun insertProductModel(item: ProductDatabaseModel) {
        data.add(0, item)
    }
}
