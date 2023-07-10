package android.template.feature.main.ui.test2

import android.template.core.ui.result.UiState
import android.template.core.ui.result.asUiState
import android.template.domain.models.Test1Model
import android.template.domain.usecases.GetTest2DataUseCase
import android.template.feature.main.ui.test1.Test1UiModel
import android.template.feature.main.ui.test1.toUiModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class Test2ViewModel(
    getTest2DataUseCase: GetTest2DataUseCase,
) : ViewModel() {
    val test2UiState: StateFlow<UiState<Test1UiModel>> = getTest2DataUseCase()
        .map(Test1Model::toUiModel)
        .asUiState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
            initialValue = UiState.Loading,
        )
}
