package android.template.core.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity
data class ProductDatabaseModel(
    val name: String,
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

@Dao
interface ProductDao {
    @Query("SELECT * FROM productdatabasemodel ORDER BY uid DESC LIMIT 10")
    fun getProductModels(): Flow<List<ProductDatabaseModel>>

    @Insert
    suspend fun insertProductModel(item: ProductDatabaseModel)
}
