package android.template.apimodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatApiModel(
    @SerialName("id")
    val id: String?,
    @SerialName("validated")
    val validated: Boolean?,
    @SerialName("owner")
    val owner: String?,
    @SerialName("file")
    val file: String?,
    @SerialName("mimetype")
    val mimeType: String?,
    @SerialName("size")
    val size: Double?,
    @SerialName("url")
    val url: String?,
)
