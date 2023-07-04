package android.template.feature.main.ui.cat

import android.template.core.ui.result.UiState
import android.template.domain.models.CatModel
import android.template.domain.usecases.GetCatUseCase
import android.template.domain.usecases.GetCatsListUseCase
import android.template.testing.core.MainDispatcherRule
import app.cash.turbine.test
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class CatViewModelTest {

    @get:Rule
    val mainDispatcherRule: MainDispatcherRule = MainDispatcherRule()

    private val fakeCatRepository = FakeCatRepository()
    private val getCatUseCase = GetCatUseCase(fakeCatRepository)
    private val getCatsListUseCase = GetCatsListUseCase(fakeCatRepository)
    private val viewModel by lazy { CatViewModel(getCatUseCase, getCatsListUseCase) }

    @Test
    fun `When the ViewModel is created Then its state is Loading`() {
        assertEquals(UiState.Loading, viewModel.catUiState.value)
        assertEquals(UiState.Loading, viewModel.catsListUiState.value)
    }

    @Test
    fun `Given a time lapse When we read the ViewModel state Then it is Success`() = runTest {
        // Given
        val catsUiModelList = catsList.map(CatModel::toUiModel).toPersistentList()
        val firstCat = UiState.Success(catsUiModelList.first())
        val secondCat = UiState.Success(catsUiModelList.last())

        // When
        viewModel.catUiState.test {
            // Then
            assertEquals(firstCat, awaitItem())
            assertEquals(secondCat, awaitItem())
        }

        // When
        viewModel.catsListUiState.test {
            // Then
            assertEquals(UiState.Success(catsUiModelList), awaitItem())
        }
    }

    @Test
    fun `Given an exception is thrown When we read the ViewModel state Then it is Error`() =
        runTest {
            // Given
            val errorRepository = FakeCatRepository(isSuccess = false)
            val getCatUseCase = GetCatUseCase(errorRepository)
            val getCatsListUseCase = GetCatsListUseCase(errorRepository)
            val viewModel by lazy { CatViewModel(getCatUseCase, getCatsListUseCase) }

            // When
            viewModel.catUiState.test {
                // Then
                assertEquals(UiState.Error(catException), awaitItem())
            }

            // When
            viewModel.catsListUiState.test {
                // Then
                assertEquals(UiState.Error(catException), awaitItem())
            }
        }
}
