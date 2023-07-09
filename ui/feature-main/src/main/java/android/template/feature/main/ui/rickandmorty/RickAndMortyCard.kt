package android.template.feature.main.ui.rickandmorty

import android.template.ui.core.R
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RickAndMortyCard(
    imageUrlsProvider: () -> List<String>,
    descriptionHeaderProvider: () -> String,
    descriptionFooterProvider: () -> String = { "" },
    onCardClick: () -> Unit = {},
    descriptionHelperContent: @Composable () -> Unit = {},
    descriptionContent: @Composable () -> Unit = {},
) {
    var isFavorite by remember { mutableStateOf(false) }

    @Composable
    fun PagerIndicator(
        modifier: Modifier = Modifier,
        pageCount: Int,
        currentPage: Int,
        selectedColor: Color = Color.White,
        inactiveColor: Color = selectedColor.copy(
            alpha = 0.66f,
        ),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier,
        ) {
            repeat(pageCount) { iteration ->
                val color = if (currentPage == iteration) selectedColor else inactiveColor
                Box(
                    modifier = Modifier.padding(2.dp).clip(CircleShape).background(color)
                        .size(if (currentPage == iteration) 8.dp else 6.dp),
                )
            }
        }
    }

    Surface(
        shape = MaterialTheme.shapes.extraLarge,
        color = Color.Transparent,
        onClick = onCardClick,
    ) {
        val pageCount = imageUrlsProvider().size
        Column(Modifier.padding(vertical = 16.dp)) {
            Box {
                val pagerState = rememberPagerState()
                val cardShape = MaterialTheme.shapes.large
                HorizontalPager(state = pagerState, pageCount = pageCount) { index ->
                    Box(
                        Modifier.fillMaxWidth().aspectRatio(1f).padding(horizontal = 16.dp)
                            .clip(cardShape),
                    ) {
                        GlideImage(
                            modifier = Modifier.matchParentSize(),
                            imageModel = { imageUrlsProvider()[index] },
                            loading = { CircularProgressIndicator(modifier = Modifier.size(20.dp)) },
                            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                            previewPlaceholder = R.drawable.placeholder_image_24,
                        )
                        Box(
                            Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(64.dp)
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            Color.Transparent,
                                            Color.Black.copy(alpha = 0.22f),
                                        ),
                                    ),
                                ),
                        )
                        Box(
                            Modifier.align(Alignment.TopCenter).fillMaxWidth().height(64.dp)
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            Color.Black.copy(alpha = 0.22f),
                                            Color.Transparent,
                                        ),
                                    ),
                                ),
                        )
                    }
                }
                PagerIndicator(
                    modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 8.dp),
                    pageCount = pageCount,
                    currentPage = pagerState.currentPage,
                )
                IconButton(
                    onClick = { isFavorite = !isFavorite },
                    modifier = Modifier.align(Alignment.TopEnd).padding(horizontal = 16.dp)
                        .padding(4.dp),
                ) {
                    if (isFavorite) {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Favorite",
                            modifier = Modifier.size(28.dp),
                            tint = Color.Red,
                        )
                    } else {
                        Icon(
                            Icons.TwoTone.Favorite,
                            contentDescription = "Not favorite",
                            modifier = Modifier.size(28.dp),
                        )
                    }
                }
            }
            Spacer(Modifier.height(24.dp))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = descriptionHeaderProvider(),
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                    )
                    descriptionHelperContent()
                }
                Spacer(Modifier.height(12.dp))
                CompositionLocalProvider(
                    LocalContentColor provides MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                ) {
                    descriptionContent()
                }
                Spacer(Modifier.height(12.dp))
                Text(
                    text = descriptionFooterProvider(),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RickAndMortyCardPreview() {
    RickAndMortyCard(
        imageUrlsProvider = ::emptyList,
        descriptionHeaderProvider = { "Delux room in hotel" },
        descriptionFooterProvider = { "$60 per night" },
        descriptionContent = { Text(text = "Description content") },
        descriptionHelperContent = {
            Row {
                Icon(Icons.Rounded.Star, contentDescription = "Rating")
                Text("4.94 (128)")
            }
        },
    )
}
