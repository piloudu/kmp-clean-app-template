package android.template.feature.main.ui.products

import kotlinx.collections.immutable.PersistentList

sealed interface MainProductsUiState {
    object Loading : MainProductsUiState
    data class Error(val throwable: Throwable) : MainProductsUiState
    data class Success(val data: PersistentList<ProductUiModel>) : MainProductsUiState
}
