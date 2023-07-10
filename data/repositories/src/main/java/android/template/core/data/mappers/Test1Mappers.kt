package android.template.core.data.mappers

import android.template.api.apimodels.Test1ApiModel
import android.template.domain.models.Test1Model
import android.template.domain.models.Url

fun Test1ApiModel.toDomainModel(): Test1Model {
    return Test1Model(Url(this.url.orEmpty()))
}

fun Test1Model.toApiModel(): Test1ApiModel {
    return Test1ApiModel(this.url.value)
}
