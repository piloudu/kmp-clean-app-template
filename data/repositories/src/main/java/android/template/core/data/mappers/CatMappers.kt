package android.template.core.data.mappers

import android.template.apimodels.CatApiModel
import android.template.domain.models.CatModel
import android.template.domain.models.MimeType
import android.template.domain.models.Owner
import android.template.domain.models.Url

fun CatApiModel.toDomainModel(): CatModel {
    return CatModel(
        owner = Owner(this.owner.orEmpty()),
        mimeType = MimeType(this.mimeType.orEmpty()),
        url = Url(this.url.orEmpty()),
    )
}

fun CatModel.toApiModel(): CatApiModel {
    return CatApiModel(
        id = null,
        validated = null,
        owner = this.owner.value,
        file = null,
        mimeType = this.mimeType.value,
        size = null,
        url = this.url.value,
    )
}
