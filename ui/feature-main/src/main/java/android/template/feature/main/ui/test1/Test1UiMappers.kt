package android.template.feature.main.ui.test1

import android.template.domain.models.Test1Model
import android.template.domain.models.Url

fun Test1Model.toUiModel(): Test1UiModel {
    return Test1UiModel(url = this.url.value)
}

fun Test1UiModel.toDomainModel(): Test1Model {
    return Test1Model(Url(this.url))
}
