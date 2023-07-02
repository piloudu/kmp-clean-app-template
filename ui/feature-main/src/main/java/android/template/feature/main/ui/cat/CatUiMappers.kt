package android.template.feature.main.ui.cat

import android.template.domain.models.CatModel
import android.template.domain.models.MimeType
import android.template.domain.models.Owner
import android.template.domain.models.Url

fun CatModel.toUiModel(): CatUiModel {
    return CatUiModel(
        owner = this.owner.value,
        mimeType = this.mimeType.value,
        url = this.url.value,
    )
}

fun CatUiModel.toDomainModel(): CatModel {
    return CatModel(
        owner = Owner(this.owner),
        mimeType = MimeType(this.mimeType),
        url = Url(this.url),
    )
}
