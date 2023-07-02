package android.template.feature.main.ui.cat

sealed interface CatUiState {
    object Loading : CatUiState
    data class Error(val throwable: Throwable) : CatUiState
    data class Success(val data: CatUiModel) : CatUiState
}
