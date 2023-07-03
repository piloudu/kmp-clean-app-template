package android.template.domain.di

import android.template.domain.usecases.AddProductsUseCase
import android.template.domain.usecases.GetCatUseCase
import android.template.domain.usecases.GetProductsUseCase
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCasesModule: Module = module {
    factoryOf(::GetProductsUseCase)
    factoryOf(::AddProductsUseCase)
    factoryOf(::GetCatUseCase)
}
