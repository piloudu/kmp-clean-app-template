package android.template.feature.main.ui.integration.test.test1

import android.template.core.ui.result.UiState
import android.template.feature.main.ui.integration.test.di.TestCase
import android.template.feature.main.ui.integration.test.di.startKoinFor
import android.template.feature.main.ui.test2.Test2ViewModel
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

class Test2ViewModelIntegrationTest : KoinTest {

    private val viewModel: Test2ViewModel by inject()

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
        assertEquals(UiState.Loading, viewModel.test2UiState.value)
    }

    @Test
    fun `Given data is fetched When read the ViewModel state Then the output is the expected`() =
        runTest {
            // Given
            startKoinFor(TestCase.SUCCESS)

            // When
            viewModel.test2UiState.test {
                // Then
                assertEquals(UiState.Success(test2UiModel), awaitItem())
            }
        }
}
