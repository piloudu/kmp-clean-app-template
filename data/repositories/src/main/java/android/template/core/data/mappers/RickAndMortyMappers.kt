package android.template.core.data.mappers

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyCharacterApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyOriginApiModel
import android.template.domain.models.Gender
import android.template.domain.models.Name
import android.template.domain.models.Planet
import android.template.domain.models.RickAndMortyModel
import android.template.domain.models.Species
import android.template.domain.models.Status
import android.template.domain.models.Url

fun RickAndMortyApiModel.toDomainModel(): RickAndMortyModel {
    val firstResult = this.results?.firstOrNull()
    return RickAndMortyModel(
        name = Name(firstResult?.name.orEmpty()),
        status = Status(firstResult?.status.orEmpty()),
        species = Species(firstResult?.species.orEmpty()),
        gender = Gender(firstResult?.gender.orEmpty()),
        planet = Planet(firstResult?.origin?.name.orEmpty()),
        imageUrl = Url(firstResult?.image.orEmpty()),
    )
}

fun RickAndMortyModel.toApiModel(): RickAndMortyApiModel {
    return RickAndMortyApiModel(
        info = null,
        results = listOf(
            RickAndMortyCharacterApiModel(
                id = null,
                name = this.name.value,
                status = this.status.value,
                species = this.species.value,
                type = null,
                gender = this.gender.value,
                origin = RickAndMortyOriginApiModel(name = this.planet.value, url = null),
                location = null,
                image = this.imageUrl.value,
                episode = listOf(),
                url = null,
                created = null,
            ),
        ),
    )
}
