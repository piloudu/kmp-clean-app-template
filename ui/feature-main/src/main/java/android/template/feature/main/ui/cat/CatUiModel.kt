package android.template.feature.main.ui.cat

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatUiModel(
    val owner: String,
    val mimeType: String,
    val url: String,
) : Parcelable
