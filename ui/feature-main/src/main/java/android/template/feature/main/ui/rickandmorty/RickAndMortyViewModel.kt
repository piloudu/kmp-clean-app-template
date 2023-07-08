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
    getRickAndMortyDataUseCase: GetRickAndMortyDataUseCase,
) : ViewModel() {
    val rickAndMortyUiState: StateFlow<UiState<RickAndMortyUiModel>> = getRickAndMortyDataUseCase()
        .map(RickAndMortyModel::toUiModel)
        .asUiState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
            initialValue = UiState.Loading,
        )
}
