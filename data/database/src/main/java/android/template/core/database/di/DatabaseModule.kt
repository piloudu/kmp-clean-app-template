package android.template.core.database.di

import android.content.Context
import android.template.core.database.AppDatabase
import android.template.core.database.ProductDao
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule: Module = module {
    factory<ProductDao> { get<AppDatabase>().getProductDao() }
    single<AppDatabase> { buildRoomDatabase(androidContext()) }
}

private fun buildRoomDatabase(appContext: Context) = Room.databaseBuilder(
    appContext,
    AppDatabase::class.java,
    "AppDatabase",
).build()
