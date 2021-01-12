package matteos_it.matteos_web.freezer.ui.freezer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "freezer")
data class FreezerData (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "food_id") val foodId: Int,
    val num: Int,
    val lim: Int,
//    @ColumnInfo(name = "create_date") val createDate: Date
)