package android.template.domain.repositories

import android.template.domain.models.RickAndMortyModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getRickAndMortyData(): Flow<RickAndMortyModel>
}
