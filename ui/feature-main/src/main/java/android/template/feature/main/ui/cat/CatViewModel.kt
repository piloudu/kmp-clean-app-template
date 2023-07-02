package android.template.feature.main.ui.cat

import android.template.domain.models.CatModel
import android.template.domain.usecases.GetCatUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CatViewModel(
    getCatUseCase: GetCatUseCase,
) : ViewModel() {
    val uiState: StateFlow<CatUiState> = getCatUseCase()
        .map<CatModel, CatUiState> { CatUiState.Success(it.toUiModel()) }
        .catch { emit(CatUiState.Error(it)) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CatUiState.Loading,
        )
}
