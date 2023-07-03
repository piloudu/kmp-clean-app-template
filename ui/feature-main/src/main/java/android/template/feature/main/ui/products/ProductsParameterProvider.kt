package android.template.feature.main.ui.products

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

class ProductsParameterProvider : PreviewParameterProvider<PersistentList<ProductUiModel>> {
    override val values: Sequence<PersistentList<ProductUiModel>> = sequenceOf(
        persistentListOf(
            ProductUiModel(
                name = "Product 1",
                price = null,
            ),
        ),
        persistentListOf(
            ProductUiModel(
                name = "Product Test",
                price = null,
            ),
        ),
    )
}
