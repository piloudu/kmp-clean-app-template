package android.template.feature.main.ui.integration.test.rickandmorty

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyCharacterApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyInfoApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyLocationApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyOriginApiModel
import android.template.feature.main.ui.rickandmorty.RickAndMortyUiModel

val rickAndMortyUiModel1: RickAndMortyUiModel = RickAndMortyUiModel(
    name = Data1.name,
    status = Data1.status,
    species = Data1.species,
    gender = Data1.gender,
    planet = Data1.planet,
    imageUrl = Data1.imageUrl,
)

val rickAndMortyUiModel2: RickAndMortyUiModel = RickAndMortyUiModel(
    name = Data2.name,
    status = Data2.status,
    species = Data2.species,
    gender = Data2.gender,
    planet = Data2.planet,
    imageUrl = Data2.imageUrl,
)

val rickAndMortyApiModel: RickAndMortyApiModel = RickAndMortyApiModel(
    info = RickAndMortyInfoApiModel(
        count = 1111,
        pages = 836,
        next = "nextPage",
        prev = "prevPage",
    ),
    results = listOf(
        RickAndMortyCharacterApiModel(
            id = 2222,
            name = Data1.name,
            status = Data1.status,
            species = Data1.species,
            type = "Test type",
            gender = Data1.gender,
            origin = RickAndMortyOriginApiModel(
                name = Data1.planet,
                url = "https://representativesr0u1ba.nxk",
            ),
            location = RickAndMortyLocationApiModel(
                name = "Location Name",
                url = "https://interactionpp0c.ylo",
            ),
            image = Data1.imageUrl,
            episode = listOf("Test episode"),
            url = "https://conceptualr.nr",
            created = "2012-08-04:11:23:16",
        ),
    ),
)

val rickAndMortyCharacterApiModel: RickAndMortyCharacterApiModel = RickAndMortyCharacterApiModel(
    id = 2222,
    name = Data2.name,
    status = Data2.status,
    species = Data2.species,
    type = "Test type",
    gender = Data2.gender,
    origin = RickAndMortyOriginApiModel(
        name = Data2.planet,
        url = "https://representativesr0u1ba.nxk",
    ),
    location = RickAndMortyLocationApiModel(
        name = "Location Name",
        url = "https://interactionpp0c.ylo",
    ),
    image = Data2.imageUrl,
    episode = listOf("Test episode"),
    url = "https://conceptualr.nr",
    created = "2012-08-04:11:23:16",
)

val rickAndMortyException: Exception = Exception()

object Data1 {
    const val name: String = "Shawndra"
    const val status: String = "Alive"
    const val species: String = "Human"
    const val gender: String = "Male"
    const val planet: String = "Earth"
    const val imageUrl: String = "https://doctork617xqvdvz.zy"
}

object Data2 {
    const val name: String = "Anisa"
    const val status: String = "Dead"
    const val species: String = "Other"
    const val gender: String = "Female"
    const val planet: String = "Unknown"
    const val imageUrl: String = "https://paczl1af3vahure.ni"
}

