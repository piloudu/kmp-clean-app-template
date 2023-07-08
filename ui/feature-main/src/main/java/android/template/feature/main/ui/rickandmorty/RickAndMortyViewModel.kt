package android.template.feature.main.ui.rickandmorty

import android.template.core.ui.result.UiState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RickAndMortyViewModel(
) : ViewModel() {
    val rickAndMortyUiState: StateFlow<UiState<RickAndMortyUiModel>> = MutableStateFlow(UiState.Loading)
//        .map {  }
//        .asUiState()
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
//            initialValue = UiState.Loading,
//        )
}
