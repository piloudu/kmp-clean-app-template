package android.template.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatModel(
    val owner: Owner,
    val mimeType: MimeType,
    val url: Url,
) : Parcelable

@Parcelize
@JvmInline
value class Owner(val value: String) : Parcelable

@Parcelize
@JvmInline
value class MimeType(val value: String) : Parcelable

@Parcelize
@JvmInline
value class Url(val value: String) : Parcelable
