package android.template.core.data.mappers

import android.template.api.apimodels.BASE_CAT_URL
import android.template.api.apimodels.CatApiModel
import android.template.domain.models.CatModel
import android.template.domain.models.MimeType
import android.template.domain.models.Owner
import android.template.domain.models.Url

fun CatApiModel.toDomainModel(): CatModel {
    return CatModel(
        owner = Owner(this.owner.orEmpty()),
        mimeType = MimeType(this.mimeType.orEmpty()),
        url = Url(BASE_CAT_URL + this.url.orEmpty()),
    )
}

fun CatModel.toApiModel(): CatApiModel {
    return CatApiModel(
        owner = this.owner.value,
        mimeType = this.mimeType.value,
        url = this.url.value,
    )
}
