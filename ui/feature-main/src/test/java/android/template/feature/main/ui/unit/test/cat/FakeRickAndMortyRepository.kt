package android.template.feature.main.ui.unit.test.cat

import android.template.domain.models.RickAndMortyModel
import android.template.domain.repositories.RickAndMortyRepository

class FakeRickAndMortyRepository(private val isSuccess: Boolean = true) : RickAndMortyRepository {
    override suspend fun getCharacter(): RickAndMortyModel {
        return if (isSuccess) {
            catsList.first()
        } else {
            throw catException
        }
    }
}
