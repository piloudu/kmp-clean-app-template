package android.template.feature.main.ui.rickandmorty

import android.template.domain.models.Gender
import android.template.domain.models.Name
import android.template.domain.models.Planet
import android.template.domain.models.RickAndMortyModel
import android.template.domain.models.Species
import android.template.domain.models.Status
import android.template.domain.models.Url

fun RickAndMortyModel.toUiModel(): RickAndMortyUiModel {
    return RickAndMortyUiModel(
        name = this.name.value,
        status = this.status.value,
        species = this.species.value,
        gender = this.gender.value,
        planet = this.planet.value,
        imageUrl = this.imageUrl.value,
    )
}

fun RickAndMortyUiModel.toDomainModel(): RickAndMortyModel {
    return RickAndMortyModel(
        name = Name(this.name),
        status = Status(this.status),
        species = Species(this.species),
        gender = Gender(this.gender),
        planet = Planet(this.planet),
        imageUrl = Url(this.imageUrl),
    )
}
