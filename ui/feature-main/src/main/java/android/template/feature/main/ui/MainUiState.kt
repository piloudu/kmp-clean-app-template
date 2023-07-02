package android.template.feature.main.ui

import kotlinx.collections.immutable.PersistentList

sealed interface MainUiState {
    object Loading : MainUiState
    data class Error(val throwable: Throwable) : MainUiState
    data class Success(val data: PersistentList<ProductUiModel>) : MainUiState
}
