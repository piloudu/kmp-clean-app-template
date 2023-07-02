package android.template.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductDatabaseModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao
}
