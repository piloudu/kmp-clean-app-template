package android.template.feature.main.ui.integration.test.rickandmorty

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import android.template.datasources.RickAndMortyDataSource
import android.template.feature.main.ui.integration.test.di.TestCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRickAndMortyDataSource(private val testCase: TestCase) : RickAndMortyDataSource {
    override fun getRickAndMortyCharacter(): Flow<RickAndMortyApiModel> {
        return flow {
            when (testCase) {
                TestCase.SUCCESS -> emit(rickAndMortyApiModel)
                TestCase.FAILURE -> throw rickAndMortyException
            }
        }
    }
}
