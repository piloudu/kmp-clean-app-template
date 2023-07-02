package android.template.core.database.di

import android.content.Context
import android.template.core.database.AppDatabase
import android.template.core.database.MyModelDao
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule: Module = module {
    factory<MyModelDao> { get<AppDatabase>().myModelDao() }
    single<AppDatabase> { buildRoomDatabase(androidContext()) }
}

private fun buildRoomDatabase(appContext: Context) = Room.databaseBuilder(
    appContext,
    AppDatabase::class.java,
    "MyModel",
).build()
