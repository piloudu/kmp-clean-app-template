package android.template.feature.main.ui.cat

import android.template.domain.models.RickAndMortyModel
import android.template.domain.models.MimeType
import android.template.domain.models.Owner
import android.template.domain.models.Url

fun RickAndMortyModel.toUiModel(): CatUiModel {
    return CatUiModel(
        owner = this.owner.value,
        mimeType = this.mimeType.value,
        url = this.url.value,
    )
}

fun CatUiModel.toDomainModel(): RickAndMortyModel {
    return RickAndMortyModel(
        owner = Owner(this.owner),
        mimeType = MimeType(this.mimeType),
        url = Url(this.url),
    )
}
