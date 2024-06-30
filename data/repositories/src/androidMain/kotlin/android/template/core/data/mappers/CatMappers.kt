package android.template.core.data.mappers

import android.template.api.apimodels.rickAndMorty.RickAndMortyCharacterApiModel
import android.template.domain.models.Location
import android.template.domain.models.Origin
import android.template.domain.models.RickAndMortyModel

fun RickAndMortyCharacterApiModel.toDomainModel(): RickAndMortyModel {
    return RickAndMortyModel(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = Origin(name = name, url = url),
        location = Location(name = name, url = url),
        image = image,
        episode = episode,
        url = url
    )
}
