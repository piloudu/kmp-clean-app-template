package android.template.feature.main.ui.test1

import android.template.core.ui.result.UiState
import android.template.core.ui.result.asUiState
import android.template.domain.models.Test1Model
import android.template.domain.usecases.GetTest1DataUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class Test1ViewModel(
    getTest1DataUseCase: GetTest1DataUseCase,
) : ViewModel() {
    val test1UiState: StateFlow<UiState<Test1UiModel>> = getTest1DataUseCase()
        .map(Test1Model::toUiModel)
        .asUiState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
            initialValue = UiState.Loading,
        )
}
