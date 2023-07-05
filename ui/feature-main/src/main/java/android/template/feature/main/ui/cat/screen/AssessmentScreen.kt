package android.template.feature.main.ui.cat.screen

import android.template.ui.core.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun AssessmentScreen(
    url: String,
    modifier: Modifier = Modifier,
    onImageClick: () -> Unit = {},
) {
    val localConfiguration = LocalConfiguration.current
    val imageModifier = Modifier
        .size(
            width = (localConfiguration.screenWidthDp - 40).dp,
            height = (localConfiguration.screenHeightDp - 80).dp,
        )
    Box(
        modifier = imageModifier,
        contentAlignment = Alignment.Center,
    ) {
        GlideImage(
            modifier = modifier,
            imageModel = { url },
            loading = { CircularProgressIndicator(modifier = modifier.size(20.dp)) },
            previewPlaceholder = R.drawable.placeholder_image_24,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AssessmentScreenPreview() {
    AssessmentScreen(url = "")

}
