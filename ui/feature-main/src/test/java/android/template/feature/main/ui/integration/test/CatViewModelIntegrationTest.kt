package android.template.feature.main.ui.integration.test

import android.template.core.ui.result.UiState
import android.template.domain.models.CatModel
import android.template.feature.main.ui.cat.CatViewModel
import android.template.feature.main.ui.cat.toUiModel
import android.template.feature.main.ui.integration.test.cat.catsList
import android.template.feature.main.ui.integration.test.di.TestCase
import android.template.feature.main.ui.integration.test.di.startKoinFor
import android.template.feature.main.ui.integration.test.fakes.cat.catException
import android.template.testing.core.MainDispatcherRule
import app.cash.turbine.test
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class CatViewModelIntegrationTest : KoinTest {

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
        Assert.assertEquals(UiState.Loading, viewModel.catUiState.value)
        Assert.assertEquals(UiState.Loading, viewModel.catsListUiState.value)
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
            Assert.assertEquals(firstCat, awaitItem())
            Assert.assertEquals(secondCat, awaitItem())
        }

        // When
        viewModel.catsListUiState.test {
            // Then
            Assert.assertEquals(UiState.Success(catsUiModelList), awaitItem())
        }
    }

    @Test
    fun `Given an exception is thrown When we read the ViewModel state Then it is Error`() =
        runTest {
            startKoinFor(TestCase.FAILURE)

            // When
            viewModel.catUiState.test {
                // Then
                Assert.assertEquals(UiState.Error(catException), awaitItem())
            }

            // When
            viewModel.catsListUiState.test {
                // Then
                Assert.assertEquals(UiState.Error(catException), awaitItem())
            }
        }
}
