package android.template.domain.di

import android.template.domain.usecases.AddModelUseCase
import android.template.domain.usecases.GetModelUseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.module.Module
import org.koin.dsl.module

val useCasesModule: Module = module {
    factory<() -> Flow<List<String>>> { GetModelUseCase(get()) }
    factory<suspend (String) -> Unit> { AddModelUseCase(get()) }
}
