package android.template.feature.main.ui.integration.test.rickandmorty

import android.template.core.ui.result.UiState
import android.template.feature.main.ui.rickandmorty.RickAndMortyViewModel
import org.junit.Test
import org.koin.test.KoinTest
import kotlin.test.assertEquals

class RickAndMortyViewModelTest : KoinTest {

    @Test
    fun `When the ViewModel is instanced Then its state is Loading`() {
        // Given

        // When
        val viewModel = RickAndMortyViewModel()

        // Then
        assertEquals(UiState.Loading, viewModel.rickAndMortyUiState.value)
    }

    @Test
    fun `Given data is fetched When read the ViewModel state Then the output is the expected`() {
        // Given

        // When
        val viewModel = RickAndMortyViewModel()

        // Then
        assertEquals(UiState.Success(rickAndMortyUiModel), viewModel.rickAndMortyUiState.value)
    }
}
