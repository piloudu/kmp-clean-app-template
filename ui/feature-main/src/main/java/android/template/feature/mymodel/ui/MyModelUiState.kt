package android.template.feature.mymodel.ui

sealed interface MyModelUiState {
    object Loading : MyModelUiState
    data class Error(val throwable: Throwable) : MyModelUiState
    data class Success(val data: ProductUiModel) : MyModelUiState
}
