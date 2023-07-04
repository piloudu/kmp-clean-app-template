package android.template.feature.main.ui.catslist

import android.template.domain.models.CatModel
import android.template.domain.usecases.GetCatsListUseCase
import android.template.feature.main.ui.cat.toUiModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CatListVieModel(
    getCatsListUseCase: GetCatsListUseCase,
) : ViewModel() {
    val uiState: StateFlow<CatsListUiState> = getCatsListUseCase()
        .map<List<CatModel>, CatsListUiState> { CatsListUiState.Success(it.map(CatModel::toUiModel).toPersistentList()) }
        .catch { emit(CatsListUiState.Error(it)) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CatsListUiState.Loading,
        )
}
