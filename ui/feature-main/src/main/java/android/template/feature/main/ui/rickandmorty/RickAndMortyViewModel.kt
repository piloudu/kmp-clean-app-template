package android.template.feature.main.ui.rickandmorty

import android.template.core.ui.result.UiState
import android.template.core.ui.result.asUiState
import android.template.core.ui.utils.toMutableStateFlow
import android.template.domain.models.RickAndMortyModel
import android.template.domain.usecases.GetRickAndMortyDataUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RickAndMortyViewModel(
    private val getRickAndMortyDataUseCase: GetRickAndMortyDataUseCase,
) : ViewModel(), RickAndMortyEventHandler {
    private val _rickAndMortyUiState: MutableStateFlow<UiState<RickAndMortyUiModel>> =
        getRickAndMortyDataUseCase()
            .map(RickAndMortyModel::toUiModel)
            .asUiState()
            .toMutableStateFlow(
                initialValue = UiState.Loading,
                coroutineScope = viewModelScope,
            )
    val rickAndMortyUiState: StateFlow<UiState<RickAndMortyUiModel>>
        get() = _rickAndMortyUiState

    override fun onEvent(event: RickAndMortyEventHandler.Event) {
        when (event) {
            RickAndMortyEventHandler.Event.NextCharacter -> {
                _rickAndMortyUiState.update { UiState.Loading }
                viewModelScope.launch {
                    getRickAndMortyDataUseCase().collect { rickAndMortyModel ->
                        _rickAndMortyUiState.update {
                            UiState.Success(
                                rickAndMortyModel.toUiModel(),
                            )
                        }
                    }
                }
            }
        }
    }
}
