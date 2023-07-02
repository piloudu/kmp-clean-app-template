package android.template.feature.mymodel.ui

import android.template.domain.models.ProductModel
import android.template.domain.usecases.AddModelUseCase
import android.template.domain.usecases.GetModelUseCase
import android.template.feature.mymodel.ui.MyModelUiState.Error
import android.template.feature.mymodel.ui.MyModelUiState.Loading
import android.template.feature.mymodel.ui.MyModelUiState.Success
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MyModelViewModel(
    getModelUseCase: GetModelUseCase,
    private val addModelUseCase: AddModelUseCase,
) : ViewModel() {

    val uiState: StateFlow<MyModelUiState> = getModelUseCase()
        .map<ProductModel, MyModelUiState> { Success(data = it.toUiModel()) }
        .catch { emit(Error(it)) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = Loading,
        )

    fun addMyModel(name: String) {
        viewModelScope.launch {
            addModelUseCase(name)
        }
    }
}
