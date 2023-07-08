package android.template.feature.main.ui.integration.test.rickandmorty

import android.template.core.ui.result.UiState
import android.template.feature.main.ui.integration.test.di.TestCase
import android.template.feature.main.ui.integration.test.di.startKoinFor
import android.template.feature.main.ui.rickandmorty.RickAndMortyViewModel
import org.junit.After
import org.junit.Test
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertEquals

class RickAndMortyViewModelTest : KoinTest {

    private val viewModel: RickAndMortyViewModel by inject()

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `When the ViewModel is instanced Then its state is Loading`() {
        // When
        startKoinFor(TestCase.SUCCESS)
        
        // Then
        assertEquals(UiState.Loading, viewModel.rickAndMortyUiState.value)
    }

    @Test
    fun `Given data is fetched When read the ViewModel state Then the output is the expected`() {
        // When
        startKoinFor(TestCase.SUCCESS)

        // Then
        assertEquals(UiState.Success(rickAndMortyUiModel), viewModel.rickAndMortyUiState.value)
    }
}
