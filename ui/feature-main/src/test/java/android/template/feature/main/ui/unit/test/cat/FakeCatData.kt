package android.template.feature.main.ui.unit.test.cat

import android.template.domain.models.Location
import android.template.domain.models.Origin
import android.template.domain.models.RickAndMortyModel

val catsList: List<RickAndMortyModel> = listOf(
    RickAndMortyModel(
        id = 2635,
        name = "Antoinette Schultz",
        status = "legimus",
        species = "mentitum",
        type = "scripserit",
        gender = "eius",
        origin = Origin(
            name = "Nita Hudson",
            url = "http://www.bing.com/search?q=condimentum"
        ),
        location = Location(
            name = "Carly Sandoval",
            url = "https://duckduckgo.com/?q=invenire"
        ),
        image = "definiebas",
        episode = listOf(),
        url = "https://search.yahoo.com/search?p=sodales"
    ),
)

val catException: Exception = Exception()
