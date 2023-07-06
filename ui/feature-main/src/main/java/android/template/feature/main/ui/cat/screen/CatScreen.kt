package android.template.feature.main.ui.cat.screen

import android.template.core.ui.result.UiState
import android.template.feature.main.ui.cat.CatUiModel
import android.template.feature.main.ui.cat.CatViewModel
import android.template.ui.core.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun CatScreen(
    modifier: Modifier = Modifier,
    testParam: String,
    catViewModel: CatViewModel = koinViewModel(),
) {
    val uiState by catViewModel.catUiState.collectAsStateWithLifecycle()

    when (uiState) {
        UiState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(modifier = Modifier)
        }

        is UiState.Success -> {
            CatScreenInternal(
                modifier = modifier,
                catUiModelProvider = (uiState as UiState.Success)::data,
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
private fun CatScreenInternal(
    modifier: Modifier = Modifier,
    catUiModelProvider: () -> CatUiModel,
) {
    val localConfiguration = LocalConfiguration.current
    val imageModifier = Modifier.size(
        width = (localConfiguration.screenWidthDp - 40).dp,
        height = (localConfiguration.screenHeightDp - 80).dp,
    )
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CatImage(modifier = imageModifier, urlProvider = catUiModelProvider()::url)
        if (catUiModelProvider().owner.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "The owner of this cat is ${catUiModelProvider().owner}")
        }
    }
}

@Composable
fun CatImage(modifier: Modifier = Modifier, urlProvider: () -> String) {
    GlideImage(
        modifier = modifier,
        imageModel = urlProvider,
        loading = { CircularProgressIndicator(modifier = modifier.size(20.dp)) },
        previewPlaceholder = R.drawable.placeholder_image_24,
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewCatScree() {
    CatScreenInternal(catUiModelProvider = {
        CatUiModel(
            owner = "Owner",
            mimeType = "image",
            url = "https://updateo.vsb",
        )
    })
}
