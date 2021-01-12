package matteos_it.matteos_web.freezer.ui.freezer

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface FreezerDataDao {
    @Insert
    fun insert(freezerData: FreezerData)

    @Update
    fun update(freezerData: FreezerData)

    @Delete
    fun delete(freezerData: FreezerData)

    @Query("delete from freezer")
    fun deleteAll()

    @Query("select * from freezer")
    fun getAll(): Flow<List<FreezerData>>

    @Query("select * from freezer where id = :id")
    fun get(id: Int): Flow<FreezerData>
}