package android.template.domain.models

data class CatModel(
    val owner: Owner,
    val mimeType: MimeType,
    val url: Url,
)

@JvmInline
value class Owner(val value: String)

@JvmInline
value class MimeType(val value: String)

@JvmInline
value class Url(val value: String)
