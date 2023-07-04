package android.template.cat

import android.template.core.ui.result.UiState
import android.template.datasources.catException
import android.template.di.getFakeDatasourceModule
import android.template.domain.models.CatModel
import android.template.feature.main.ui.cat.CatViewModel
import android.template.feature.main.ui.cat.toUiModel
import android.template.testing.core.MainDispatcherRule
import app.cash.turbine.test
import com.example.di.koinTestModules
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class CatViewModelTest : KoinTest {

    @get:Rule
    val mainDispatcherRule: MainDispatcherRule = MainDispatcherRule()

    private val viewModel: CatViewModel by inject()

    @After
    fun tearDown() {
        stopKoin()
    }
    
    @Test
    fun `When the ViewModel is created Then its state is Loading`() {
        startKoinFor(TestCase.SUCCESS)
        assertEquals(UiState.Loading, viewModel.catUiState.value)
        assertEquals(UiState.Loading, viewModel.catsListUiState.value)
    }

    @Test
    fun `Given a time lapse When we read the ViewModel state Then it is Success`() = runTest {
        // Given
        startKoinFor(TestCase.SUCCESS)
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
            startKoinFor(TestCase.FAILURE)

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

fun startKoinFor(testCase: TestCase) {
    startKoin {
        val fakeNetworkModule = getFakeDatasourceModule(testCase.value)
        modules(koinTestModules + fakeNetworkModule)
    }
}

enum class TestCase(val value: Boolean) {
    SUCCESS(true), FAILURE(false)
}
