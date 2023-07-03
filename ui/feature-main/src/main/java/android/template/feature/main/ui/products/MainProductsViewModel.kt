package android.template.feature.main.ui.products

import android.template.domain.models.ProductModel
import android.template.domain.usecases.AddModelUseCase
import android.template.domain.usecases.GetProductsUseCase
import android.template.feature.main.ui.products.MainProductsUiState.Error
import android.template.feature.main.ui.products.MainProductsUiState.Loading
import android.template.feature.main.ui.products.MainProductsUiState.Success
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainProductsViewModel(
    getProductsUseCase: GetProductsUseCase,
    private val addProductUseCase: AddModelUseCase,
) : ViewModel() {

    val uiState: StateFlow<MainProductsUiState> = getProductsUseCase()
        .map<List<ProductModel>, MainProductsUiState> { Success(data = it.toUiModel()) }
        .catch { emit(Error(it)) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = Loading,
        )

    fun addProduct(productsList: List<ProductUiModel>) {
        viewModelScope.launch {
            addProductUseCase(productsList.toDomainModel())
        }
    }
}
