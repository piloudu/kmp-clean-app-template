package android.template.feature.main.ui.integration.test.rickandmorty

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyCharacterApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyInfoApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyLocationApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyOriginApiModel
import android.template.feature.main.ui.rickandmorty.RickAndMortyUiModel

private const val name = "Shawndra"
private const val status = "Alive"
private const val species = "Human"
private const val gender = "Male"
private const val planet = "Earth"
private const val imageUrl = "https://doctork617xqvdvz.zy"

val rickAndMortyUiModel: RickAndMortyUiModel = RickAndMortyUiModel(
    name = name,
    status = status,
    species = species,
    gender = gender,
    planet = planet,
    imageUrl = imageUrl,
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
            name = name,
            status = status,
            species = species,
            type = "Test type",
            gender = gender,
            origin = RickAndMortyOriginApiModel(
                name = planet,
                url = "https://representativesr0u1ba.nxk",
            ),
            location = RickAndMortyLocationApiModel(
                name = "Location Name",
                url = "https://interactionpp0c.ylo",
            ),
            image = imageUrl,
            episode = listOf("Test episode"),
            url = "https://conceptualr.nr",
            created = "2012-08-04:11:23:16",
        ),
    ),
)

val rickAndMortyException: Exception = Exception()
