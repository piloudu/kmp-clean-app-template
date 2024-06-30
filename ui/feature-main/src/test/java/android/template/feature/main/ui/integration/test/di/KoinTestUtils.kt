package android.template.feature.main.ui.integration.test.di

import android.template.datasources.RickAndMortyDataSource
import android.template.datasources.ProductDataSource
import android.template.feature.main.ui.integration.test.cat.FakeRickAndMortyDatasource
import android.template.feature.main.ui.integration.test.products.FakeProductsDatasource
import com.example.di.koinTestModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun startKoinFor(testCase: TestCase) {
    startKoin {
        val fakeNetworkModule = getFakeDatasourceModule(testCase)
        modules(koinTestModules + fakeNetworkModule)
    }
}

enum class TestCase {
    SUCCESS, FAILURE
}

fun getFakeDatasourceModule(testCase: TestCase): Module = module {
    factory<ProductDataSource> { FakeProductsDatasource(testCase) }
    factory<RickAndMortyDataSource> { FakeRickAndMortyDatasource(testCase) }
}
