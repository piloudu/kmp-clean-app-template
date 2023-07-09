package android.template.feature.main.ui.products

import android.template.core.ui.MyApplicationTheme
import android.template.core.ui.result.UiState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.PersistentList
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainProductsViewModel = koinViewModel(),
    onClickGoToCatScreen: () -> Unit = { },
    onClickGoToRickAndMortyScreen: () -> Unit = { },
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var count: Int by remember { mutableStateOf(0) }

    when (uiState) {
        UiState.Loading -> {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                Button(modifier = Modifier.fillMaxWidth(), onClick = { count++ }) {
                    Text(text = "Count is: $count")
                }
            }
        }

        is UiState.Success -> {
            MainScreen(
                modifier = modifier,
                productsUiModels = (uiState as UiState.Success).data,
                onSave = viewModel::addProduct,
                onClickGoToCatScreen = onClickGoToCatScreen,
                onClickGoToRickAndMortyScreen = onClickGoToRickAndMortyScreen,
            )
        }

        is UiState.Error -> {
            Text(
                text = "Exception thrown: ${(uiState as UiState.Error).throwable}",
                color = Color.Red,
            )
        }
    }
}

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
    productsUiModels: PersistentList<ProductUiModel>,
    onSave: (List<ProductUiModel>) -> Unit = { },
    onClickGoToCatScreen: () -> Unit = { },
    onClickGoToRickAndMortyScreen: () -> Unit = { },
) {
    Column(modifier) {
        var nameMyModel by remember { mutableStateOf("Compose") }
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            TextField(
                value = nameMyModel,
                onValueChange = { nameMyModel = it },
            )

            Button(modifier = Modifier.width(96.dp), onClick = { onSave(productsUiModels) }) {
                Text("Save")
            }
        }
        productsUiModels.forEach { productUiModel ->
            Text("Saved item: ${productUiModel.name}")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onClickGoToCatScreen) {
            Text(text = "Go to cat screen")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onClickGoToRickAndMortyScreen) {
            Text(text = "Go to Rick And Morty screen")
        }
    }
}

// @MultiplePreview
@Preview(showBackground = true)
@Composable
private fun PortraitPreview(@PreviewParameter(ProductsParameterProvider::class) data: PersistentList<ProductUiModel>) {
    MyApplicationTheme {
        MainScreen(productsUiModels = data)
    }
}
