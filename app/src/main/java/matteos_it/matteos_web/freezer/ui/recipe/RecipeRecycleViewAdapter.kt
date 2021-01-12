package matteos_it.matteos_web.freezer.ui.recipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import matteos_it.matteos_web.freezer.R


class RecipeRecycleViewAdapter(private val recipeList: ArrayList<RecipeData>, private val listener: AddRecipeListener): RecyclerView.Adapter<RecipeRecycleViewAdapter.ViewHolder>() {

    // Viewの初期化
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val image: ImageView
        val name: TextView = view.findViewById(R.id.row_recipe_name)
        val description: TextView = view.findViewById(R.id.row_recipe_description)
        var row: LinearLayout = view.findViewById(R.id.row_recipe_row)
    }

    // レイアウトの設定
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_recipe, viewGroup, false)
        return ViewHolder(view)
    }

    // Viewの設定
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val recipe = recipeList[position]

//        viewHolder.image.setImageResource(animal.imageId)
        viewHolder.name.text = recipe.name
        viewHolder.description.text = recipe.description

        // 行を tap した際の挙動を追加
        viewHolder.row.setOnClickListener {
            listener.buttonTapped(recipe)
        }
    }

    // 表示数を返す
    override fun getItemCount() = recipeList.size
}