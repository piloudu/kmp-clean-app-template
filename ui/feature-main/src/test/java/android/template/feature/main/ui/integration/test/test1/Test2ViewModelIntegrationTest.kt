package android.template.feature.main.ui.integration.test.test1

import android.template.core.ui.result.UiState
import android.template.feature.main.ui.integration.test.di.TestCase
import android.template.feature.main.ui.integration.test.di.startKoinFor
import android.template.feature.main.ui.test2.Test2ViewModel
import org.junit.After
import org.junit.Test
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertEquals

class Test2ViewModelIntegrationTest : KoinTest {

    private val viewModel: Test2ViewModel by inject()

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
}
