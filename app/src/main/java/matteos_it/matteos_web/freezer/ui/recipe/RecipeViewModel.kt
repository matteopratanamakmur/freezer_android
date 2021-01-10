package matteos_it.matteos_web.freezer.ui.recipe

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader

class RecipeViewModel(application: Application) : AndroidViewModel(application) {
    private val assetManager = application.resources.assets

    private val _recipeData = MutableLiveData<ArrayList<RecipeData>>().apply {
        // json ファイルを読み込む
        val inputStream = assetManager.open("recipe.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val json = bufferedReader.readText()
        // json ファイルをパース
        value = Json.decodeFromString<ArrayList<RecipeData>>(json)
    }
    val recipeData: LiveData<ArrayList<RecipeData>> = _recipeData
}