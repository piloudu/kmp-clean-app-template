package android.template.integration.tests.di

import android.template.datasources.CatDataSource
import android.template.datasources.ProductDataSource
import android.template.integration.tests.fakes.cat.FakeCatDatasource
import android.template.integration.tests.fakes.products.FakeProductsDatasource
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
