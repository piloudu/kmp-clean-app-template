package android.template.feature.main.ui

sealed interface MainUiState {
    object Loading : MainUiState
    data class Error(val throwable: Throwable) : MainUiState
    data class Success(val data: List<ProductUiModel>) : MainUiState
}
