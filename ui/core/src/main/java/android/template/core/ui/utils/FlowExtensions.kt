package android.template.core.ui.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

fun <T> Flow<T>.toMutableStateFlow(
    initialValue: T,
    coroutineScope: CoroutineScope,
): MutableStateFlow<T> {
    val mutableStateFlow = MutableStateFlow(initialValue)

    coroutineScope.launch {
        collect { value ->
            mutableStateFlow.update { value }
        }
    }

    return mutableStateFlow
}
