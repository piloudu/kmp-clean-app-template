package android.template.di

import org.koin.core.definition.KoinDefinition
import org.koin.core.qualifier.QualifierValue
import org.koin.core.qualifier.StringQualifier

infix fun <T> KoinDefinition<T>.named(name: QualifierValue): KoinDefinition<T> = this.apply {
    factory.beanDefinition.qualifier = StringQualifier(name)
}
