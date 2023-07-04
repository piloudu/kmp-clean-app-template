package android.template.feature.main.ui.cat

import android.template.domain.models.CatModel
import android.template.domain.usecases.GetCatUseCase
import android.template.domain.usecases.GetCatsListUseCase
import android.template.feature.main.ui.catslist.CatsListUiState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CatViewModel(
    getCatUseCase: GetCatUseCase,
    getCatsListUseCase: GetCatsListUseCase
) : ViewModel() {
    val catUiState: StateFlow<CatUiState> = getCatUseCase()
        .map<CatModel, CatUiState> { CatUiState.Success(it.toUiModel()) }
        .catch { emit(CatUiState.Error(it)) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CatUiState.Loading,
        )

    val catsListUiState: StateFlow<CatsListUiState> = getCatsListUseCase()
        .map<List<CatModel>, CatsListUiState> { CatsListUiState.Success(it.map(CatModel::toUiModel).toPersistentList()) }
        .catch { emit(CatsListUiState.Error(it)) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CatsListUiState.Loading,
        )
}
