package android.template.feature.main.ui.products

import android.template.core.ui.result.UiState
import android.template.core.ui.result.asUiState
import android.template.domain.models.ProductModel
import android.template.domain.usecases.AddProductsUseCase
import android.template.domain.usecases.GetProductsUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainProductsViewModel(
    getProductsUseCase: GetProductsUseCase,
    private val addProductUseCase: AddProductsUseCase,
) : ViewModel() {

    val uiState: StateFlow<UiState<PersistentList<ProductUiModel>>> = getProductsUseCase()
        .map { it.map(ProductModel::toUiModel).toPersistentList() }
        .asUiState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiState.Loading,
        )

    fun addProduct(productsList: List<ProductUiModel>) {
        viewModelScope.launch {
            addProductUseCase(productsList.map(ProductUiModel::toDomainModel))
        }
    }
}
