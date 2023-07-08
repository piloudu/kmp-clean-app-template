package android.template.feature.main.ui.integration.test.rickandmorty

import android.template.core.ui.result.UiState
import android.template.feature.main.ui.integration.test.di.TestCase
import android.template.feature.main.ui.integration.test.di.startKoinFor
import android.template.feature.main.ui.rickandmorty.RickAndMortyViewModel
import android.template.testing.core.MainDispatcherRule
import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertEquals

class RickAndMortyViewModelIntegrationTest : KoinTest {

    private val viewModel: RickAndMortyViewModel by inject()

    @get:Rule
    val mainDispatcherRule: MainDispatcherRule = MainDispatcherRule()

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `When the ViewModel is instanced Then its state is Loading`() {
        // Given
        startKoinFor(TestCase.SUCCESS)

        // Then
        assertEquals(UiState.Loading, viewModel.rickAndMortyUiState.value)
    }

    @Test
    fun `Given data is fetched When read the ViewModel state Then the output is the expected`() =
        runTest {
            // Given
            startKoinFor(TestCase.SUCCESS)

            // When
            viewModel.rickAndMortyUiState.test {
                // Then
                assertEquals(UiState.Success(rickAndMortyUiModel), awaitItem())
            }
        }

    @Test
    fun `Given an exception is thrown When we read the ViewModel state Then it is Error`() =
        runTest {
            startKoinFor(TestCase.FAILURE)

            // When
            viewModel.rickAndMortyUiState.test {
                // Then
                Assert.assertEquals(UiState.Error(rickAndMortyException), awaitItem())
            }
        }
}
