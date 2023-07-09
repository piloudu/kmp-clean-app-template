package android.template.core.ui.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

fun <T> Flow<T>.toMutableStateFlow(
    initialValue: T,
    coroutineScope: CoroutineScope,
): MutableStateFlow<T> {
    val mutableStateFlow = MutableStateFlow(initialValue)

    coroutineScope.launch {
        collect { value ->
            mutableStateFlow.value = value
        }
    }

    return mutableStateFlow
}
