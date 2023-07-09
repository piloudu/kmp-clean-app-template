package android.template.feature.main.ui.rickandmorty

import android.template.core.ui.result.UiState
import android.template.core.ui.result.asUiState
import android.template.domain.models.RickAndMortyModel
import android.template.domain.usecases.GetRickAndMortyDataUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class RickAndMortyViewModel(
    private val getRickAndMortyDataUseCase: GetRickAndMortyDataUseCase,
) : ViewModel(), RickAndMortyEventHandler {
    var rickAndMortyUiState: StateFlow<UiState<RickAndMortyUiModel>> = getRickAndMortyStateFlow()
        private set

    override fun onEvent(event: RickAndMortyEventHandler.Event) {
        when (event) {
            RickAndMortyEventHandler.Event.NextCharacter -> {
                rickAndMortyUiState = getRickAndMortyStateFlow()
            }
        }
    }

    private fun getRickAndMortyStateFlow() = getRickAndMortyDataUseCase()
        .map(RickAndMortyModel::toUiModel)
        .asUiState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
            initialValue = UiState.Loading,
        )
}
