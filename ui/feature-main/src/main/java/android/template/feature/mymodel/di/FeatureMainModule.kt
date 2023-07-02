package android.template.feature.mymodel.di

import android.template.feature.mymodel.ui.MyModelViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val featureMainModule: Module = module {
    viewModelOf(::MyModelViewModel)
}
