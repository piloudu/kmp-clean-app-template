package android.template.feature.main.ui.integration.test.test1

import android.template.core.ui.result.UiState
import android.template.feature.main.ui.test2.Test2ViewModel
import org.junit.Test
import kotlin.test.assertEquals

class Test2ViewModelIntegrationTest {
    @Test
    fun `When the ViewModel is created Then its state is Loading`() {
        // Given

        // When
        val viewModel = Test2ViewModel()
        
        // Then
        assertEquals(UiState.Loading, viewModel.test2UiState.value)
    }
}
