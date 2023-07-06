package android.template.feature.main.ui.integration.test.di

import android.template.datasources.CatDataSource
import android.template.datasources.ProductDataSource
import android.template.feature.main.ui.integration.test.fakes.cat.FakeCatDatasource
import android.template.feature.main.ui.integration.test.fakes.products.FakeProductsDatasource
import com.example.di.koinTestModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun startKoinFor(testCase: TestCase) {
    startKoin {
        val fakeNetworkModule = getFakeDatasourceModule(testCase.value)
        modules(koinTestModules + fakeNetworkModule)
    }
}

enum class TestCase(val value: Boolean) {
    SUCCESS(true), FAILURE(false)
}

fun getFakeDatasourceModule(isSuccess: Boolean): Module = module {
    factory<ProductDataSource> { FakeProductsDatasource(isSuccess) }
    factory<CatDataSource> { FakeCatDatasource(isSuccess) }
}
