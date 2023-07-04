package android.template.feature.main.ui.cat

import android.template.core.ui.result.UiState
import android.template.core.ui.result.asUiState
import android.template.domain.models.CatModel
import android.template.domain.usecases.GetCatUseCase
import android.template.domain.usecases.GetCatsListUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CatViewModel(
    getCatUseCase: GetCatUseCase,
    getCatsListUseCase: GetCatsListUseCase,
) : ViewModel() {
    val catUiState: StateFlow<UiState<CatUiModel>> = getCatUseCase()
        .map(CatModel::toUiModel)
        .asUiState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiState.Loading,
        )

    val catsListUiState: StateFlow<UiState<PersistentList<CatUiModel>>> = getCatsListUseCase()
        .map { it.map(CatModel::toUiModel).toPersistentList() }
        .asUiState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiState.Loading,
        )
}
