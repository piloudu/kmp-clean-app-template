package android.template.core.ui.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface UiState<out T> {
    data class Success<out T>(val data: T) : UiState<T>
    data class Error(val throwable: Throwable? = null) : UiState<Nothing>
    object Loading : UiState<Nothing>
}

fun <T> Flow<T>.asUiState(): Flow<UiState<T>> {
    return this
        .map<T, UiState<T>> {
            UiState.Success(it)
        }
        .onStart { emit(UiState.Loading) }
        .catch { emit(UiState.Error(it)) }
}
