package android.template.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myModelDao(): MyModelDao
}
