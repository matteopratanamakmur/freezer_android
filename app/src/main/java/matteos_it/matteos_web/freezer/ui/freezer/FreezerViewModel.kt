package matteos_it.matteos_web.freezer.ui.freezer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.room.Room

class FreezerViewModel(application: Application) : AndroidViewModel(application) {
    private val database =
        Room.databaseBuilder(application.baseContext, FreezerDatabase::class.java, "freezer")
            .build()
    private val freezerDataDao = database.freezerDataDao()
    val freezerData: LiveData<List<FreezerData>>
            = freezerDataDao.getAll().asLiveData()
}