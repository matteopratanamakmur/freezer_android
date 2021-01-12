package matteos_it.matteos_web.freezer.ui.freezer

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FreezerData::class], version = 1)
abstract class FreezerDatabase : RoomDatabase() {
    abstract fun freezerDataDao(): FreezerDataDao
}