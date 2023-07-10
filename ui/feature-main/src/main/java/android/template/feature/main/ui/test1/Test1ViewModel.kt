package android.template.feature.main.ui.test1

import android.template.core.ui.result.UiState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Test1ViewModel() : ViewModel() {
    val test1UiState: StateFlow<UiState<Any>> = MutableStateFlow(UiState.Loading)
}
