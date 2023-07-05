package android.template.feature.main.ui

import android.template.core.ui.result.UiState
import android.template.domain.models.ProductModel
import android.template.domain.repositories.ProductsRepository
import android.template.domain.usecases.AddProductsUseCase
import android.template.domain.usecases.GetProductsUseCase
import android.template.feature.main.ui.cat.catException
import android.template.feature.main.ui.products.MainProductsViewModel
import android.template.feature.main.ui.products.productsException
import android.template.feature.main.ui.products.productsList
import android.template.feature.main.ui.products.toUiModel
import android.template.testing.core.MainDispatcherRule
import app.cash.turbine.test
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainProductsViewModelTest {

    @get:Rule
    val mainDispatcherRule: MainDispatcherRule = MainDispatcherRule()

    private val repository: ProductsRepository = FakeProductsRepository()
    private val getProductsUseCase: GetProductsUseCase = GetProductsUseCase(repository)
    private val addProductsUseCase: AddProductsUseCase = AddProductsUseCase(repository)
    private val viewModel by lazy { MainProductsViewModel(getProductsUseCase, addProductsUseCase) }

    @Ignore
    @Test
    fun `When the ViewModel is created Then its state is Loading`() = runTest {
        assertEquals(UiState.Loading, viewModel.uiState.value)
    }

    @Ignore
    @Test
    fun `Given a time lapse When we read the ViewModel state Then it is Success`() = runTest {
        viewModel.uiState.test {
            val expected = UiState.Success(
                productsList.map(ProductModel::toUiModel).toPersistentList(),
            )
            assertEquals(expected, awaitItem())
        }
    }

    @Ignore
    @Test
    fun `Given an exception is thrown When we read the ViewModel state Then it is Error`() =
        runTest {
            // Given
            val errorRepository = FakeProductsRepository(isSuccess = false)
            val getProductsUseCase = GetProductsUseCase(errorRepository)
            val addProductsUseCase = AddProductsUseCase(errorRepository)
            val viewModel = MainProductsViewModel(getProductsUseCase, addProductsUseCase)

            // When
            viewModel.uiState.test {
                // Then
                assertEquals(UiState.Error(productsException), awaitItem())
            }
        }
}
