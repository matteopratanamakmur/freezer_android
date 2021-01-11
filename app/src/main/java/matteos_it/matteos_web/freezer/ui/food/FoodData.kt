package matteos_it.matteos_web.freezer.ui.food

import kotlinx.serialization.Serializable

@Serializable
data class FoodData (
    val id: Int,
    val name: String,
    val description: String,
    val imageName: String
)