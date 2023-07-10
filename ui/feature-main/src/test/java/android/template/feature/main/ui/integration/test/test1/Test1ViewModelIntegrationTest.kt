package android.template.feature.main.ui.integration.test.test1

import android.template.core.ui.result.UiState
import android.template.feature.main.ui.integration.test.di.TestCase
import android.template.feature.main.ui.integration.test.di.startKoinFor
import android.template.feature.main.ui.test1.Test1ViewModel
import android.template.testing.core.MainDispatcherRule
import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertEquals

class Test1ViewModelIntegrationTest : KoinTest {

    private val viewModel: Test1ViewModel by inject()

    @get:Rule
    val mainDispatcherRule: MainDispatcherRule = MainDispatcherRule()

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `When the ViewModel is created Then its state is Loading`() {
        // Given
        startKoinFor(TestCase.SUCCESS)

        // Then
        assertEquals(UiState.Loading, viewModel.test1UiState.value)
    }

    @Test
    fun `Given data is fetched When read the ViewModel state Then the output is the expected`() =
        runTest {
            // Given
            startKoinFor(TestCase.SUCCESS)

            // When
            viewModel.test1UiState.test {
                // Then
                assertEquals(UiState.Success(test1UiModel), awaitItem())
            }
        }

    @Test
    fun `Given an exception is thrown When we read the ViewModel state Then it is Error`() =
        runTest {
            // Given
            startKoinFor(TestCase.FAILURE)

            // When
            viewModel.test1UiState.test {
                // Then
                assertEquals(UiState.Error(test1Exception), viewModel.test1UiState.value)
            }
        }
}
