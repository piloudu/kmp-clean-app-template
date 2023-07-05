package android.template.domain.models

import java.io.Serializable

data class CatModel(
    val owner: Owner,
    val mimeType: MimeType,
    val url: Url,
) : Serializable

@JvmInline
value class Owner(val value: String)

@JvmInline
value class MimeType(val value: String) : Serializable

@JvmInline
value class Url(val value: String) : Serializable
