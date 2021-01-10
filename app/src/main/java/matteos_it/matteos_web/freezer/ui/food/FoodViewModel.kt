package matteos_it.matteos_web.freezer.ui.food

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader

class FoodViewModel(application: Application) : AndroidViewModel(application) {
    private val assetManager = application.resources.assets

    private val _foodData = MutableLiveData<ArrayList<FoodData>>().apply {
        // json ファイルを読み込む
        val inputStream = assetManager.open("food.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val json = bufferedReader.readText()
        // json ファイルをパース
        value = Json.decodeFromString<ArrayList<FoodData>>(json)
    }
    val foodData: LiveData<ArrayList<FoodData>> = _foodData
}