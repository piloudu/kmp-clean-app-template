package android.template.feature.main.ui.cat.screen

import android.template.core.ui.MultiplePreview
import android.template.feature.main.ui.cat.CatUiModel
import android.template.feature.main.ui.cat.CatUiState
import android.template.feature.main.ui.cat.CatViewModel
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun CatScreen(
    modifier: Modifier = Modifier,
    catViewModel: CatViewModel = koinViewModel(),
) {
    val uiState by catViewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        CatUiState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(modifier = Modifier)
        }

        is CatUiState.Success -> {
            CatScreenInternal(modifier = modifier, catUiModelProvider = (uiState as CatUiState.Success)::data)
        }

        is CatUiState.Error -> {
            Text(
                text = "Exception thrown: ${(uiState as CatUiState.Error).throwable}",
                color = Color.Red,
            )
        }
    }
}

@Composable
private fun CatScreenInternal(
    modifier: Modifier,
    catUiModelProvider: () -> CatUiModel,
) {
    val localConfiguration = LocalConfiguration.current
    val imageModifier = Modifier.size(
        width = (localConfiguration.screenWidthDp - 40).dp,
        height = (localConfiguration.screenHeightDp - 80).dp,
    )
    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
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
    )
}

@MultiplePreview
@Composable
private fun PreviewCatScree() {
    CatScreen()
}
