package android.template.feature.main.ui.cat

import android.template.domain.models.CatModel
import android.template.domain.usecases.GetCatUseCase
import android.template.domain.usecases.GetCatsListUseCase
import android.template.feature.main.ui.catslist.CatsListUiState
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
        assertEquals(CatUiState.Loading, viewModel.catUiState.value)
        assertEquals(CatsListUiState.Loading, viewModel.catsListUiState.value)
    }
    
    @Test
    fun `Given a time lapse When we read the ViewModel state Then it is Success`() = runTest {
        val catsUiModelList = catsList.map(CatModel::toUiModel).toPersistentList()
        val firstCat = CatUiState.Success(catsUiModelList.first())
        val secondCat = CatUiState.Success(catsUiModelList.last())
        viewModel.catUiState.test {
            assertEquals(firstCat, awaitItem())
            assertEquals(secondCat, awaitItem())
        }

        viewModel.catsListUiState.test {
            assertEquals(CatsListUiState.Success(catsUiModelList), awaitItem())
        }
    }
}
