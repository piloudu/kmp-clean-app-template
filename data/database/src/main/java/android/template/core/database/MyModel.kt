package android.template.core.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity
data class MyModel(
    val name: String,
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

@Dao
interface MyModelDao {
    @Query("SELECT * FROM mymodel ORDER BY uid DESC LIMIT 10")
    fun getMyModels(): Flow<List<MyModel>>

    @Insert
    suspend fun insertMyModel(item: MyModel)
}
