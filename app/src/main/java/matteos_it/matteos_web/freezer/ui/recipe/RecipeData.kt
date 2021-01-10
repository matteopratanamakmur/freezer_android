package matteos_it.matteos_web.freezer.ui.recipe

import kotlinx.serialization.Serializable

@Serializable
data class RecipeData (
    val id: Int,
    val name: String,
    val description: String,
    val imageName: String,
    val foodNums: String
)