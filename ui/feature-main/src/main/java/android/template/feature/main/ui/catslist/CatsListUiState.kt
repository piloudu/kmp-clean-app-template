package android.template.feature.main.ui.catslist

import android.template.feature.main.ui.cat.CatUiModel
import kotlinx.collections.immutable.PersistentList

sealed interface CatsListUiState {
    object Loading : CatsListUiState
    data class Success(val data: PersistentList<CatUiModel>) : CatsListUiState
    data class Error(val throwable: Throwable) : CatsListUiState
}
