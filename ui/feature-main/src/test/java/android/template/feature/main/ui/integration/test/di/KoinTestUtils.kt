package android.template.feature.main.ui.integration.test.di

import android.template.datasources.CatDataSource
import android.template.datasources.ProductDataSource
import android.template.datasources.RickAndMortyDataSource
import android.template.datasources.Test1DataSource
import android.template.datasources.Test2DataSource
import android.template.feature.main.ui.integration.test.cat.FakeCatDatasource
import android.template.feature.main.ui.integration.test.products.FakeProductsDatasource
import android.template.feature.main.ui.integration.test.rickandmorty.FakeRickAndMortyDataSource
import android.template.feature.main.ui.integration.test.test1.FakeTest1DataSource
import android.template.feature.main.ui.integration.test.test2.FakeTest2DataSource
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
    SUCCESS, FAILURE_STATE_UPDATE, FAILURE
}

fun getFakeDatasourceModule(testCase: TestCase): Module = module {
    factory<ProductDataSource> { FakeProductsDatasource(testCase) }
    factory<CatDataSource> { FakeCatDatasource(testCase) }
    factory<RickAndMortyDataSource> { FakeRickAndMortyDataSource(testCase) }
    factory<Test1DataSource> { FakeTest1DataSource(testCase) }
    factory<Test2DataSource> { FakeTest2DataSource(testCase) }
}
