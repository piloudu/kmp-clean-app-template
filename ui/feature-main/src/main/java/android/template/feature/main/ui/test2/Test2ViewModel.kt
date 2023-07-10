package android.template.feature.main.ui.test2

import android.template.core.ui.result.UiState
import androidx.lifecycle.ViewModel

import android.template.core.ui.result.asUiState
import android.template.feature.main.ui.test1.Test1UiModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class Test2ViewModel(
) : ViewModel() {
    val test2UiState: StateFlow<UiState<Test1UiModel>> = MutableStateFlow(UiState.Loading)
//        .map {  }
//        .asUiState()
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
//            initialValue = UiState.Loading,
//        )
}

