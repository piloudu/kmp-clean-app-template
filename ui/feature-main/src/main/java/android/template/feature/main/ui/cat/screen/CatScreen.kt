package android.template.feature.main.ui.cat.screen

import android.template.feature.main.ui.cat.CatUiModel
import android.template.feature.main.ui.cat.CatUiState
import android.template.feature.main.ui.cat.CatViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

    if (uiState is CatUiState.Success) {
        CatScreen(modifier = modifier, (uiState as CatUiState.Success).data)
    }
}

@Composable
private fun CatScreen(
    modifier: Modifier,
    uiModel: CatUiModel,
) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        CatImage(modifier, uiModel.url, uiModel.mimeType)
        if (uiModel.owner.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "The owner of this cat is ${uiModel.owner}")
        }
    }
}

@Composable
fun CatImage(modifier: Modifier, url: String, mimeType: String) {
    GlideImage(
        modifier = modifier,
        imageModel = { url },
    )
}

@Preview(name = "CatScree")
@Composable
private fun PreviewCatScree() {
    CatScreen()
}
