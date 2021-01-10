package matteos_it.matteos_web.freezer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import matteos_it.matteos_web.freezer.ui.food.FoodData
import matteos_it.matteos_web.freezer.ui.recipe.RecipeData
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_freezer, R.id.navigation_recipe, R.id.navigation_food))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // 初期化
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        // json ファイルを読み込む
        val foodJson = readJsonFile("food.json")
        val recipeJson = readJsonFile("recipe.json")
        // json ファイルをパース
        val foodData = Json.decodeFromString<List<FoodData>>(foodJson)
        val recipeData = Json.decodeFromString<List<RecipeData>>(recipeJson)
        // bundle に値をいれる
        savedInstanceState?.putString("food", foodJson)
        savedInstanceState?.putString("recipe", recipeJson)
    }

    private fun readJsonFile(path: String): String {
        val assetManager = resources.assets
        // json ファイルを読み込む
        val inputStream = assetManager.open(path)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        return bufferedReader.readText()
    }
}