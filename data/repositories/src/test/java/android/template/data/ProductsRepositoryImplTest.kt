package android.template.data

import android.template.core.data.repositories.ProductsRepositoryImpl
import android.template.domain.models.Price
import android.template.domain.models.ProductModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit tests for [ProductsRepositoryImpl].
 */
class ProductsRepositoryImplTest {

    private val repository = ProductsRepositoryImpl(FakeProductDao(), FakeDataSource())

    @Test
    fun `When execute getProductModels() Then retrieves the expected products`() {
        // When
        val productModels = repository.getProductModels()

        // Then
        assertEquals(productModels, productsList)
    }

    @Test
    fun `Given a product model When we set it Then we can retrieve it`() = runTest {
        // Given
        val productModel = listOf(
            ProductModel(
                name = "Database Product",
                price = Price(value = 898.91),
            ),
        )

        // When
        repository.setProductModel(productModel)
        val result = repository.getProductModels().first()

        // Then
        assertEquals(productModel, result)
    }
}
