package android.template.domain.usecases

import android.template.domain.models.Gender
import android.template.domain.models.Name
import android.template.domain.models.Planet
import android.template.domain.models.RickAndMortyModel
import android.template.domain.models.Species
import android.template.domain.models.Status
import android.template.domain.models.Url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetRickAndMortyUseCase(

) : () -> Flow<RickAndMortyModel> {
    override fun invoke(): Flow<RickAndMortyModel> {
        return flowOf(
            RickAndMortyModel(
                name = Name("Shawndra"),
                status = Status("Alive"),
                species = Species("Human"),
                gender = Gender("Male"),
                planet = Planet("Earth"),
                imageUrl = Url("https://doctork617xqvdvz.zy"),
            ),
        )
    }
}
