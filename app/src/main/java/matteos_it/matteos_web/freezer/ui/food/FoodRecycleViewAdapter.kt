package matteos_it.matteos_web.freezer.ui.food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import matteos_it.matteos_web.freezer.R


class FoodRecycleViewAdapter(private val foodList: ArrayList<FoodData>): RecyclerView.Adapter<FoodRecycleViewAdapter.ViewHolder>() {

    // Viewの初期化
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val image: ImageView
        val name: TextView = view.findViewById(R.id.row_food_name)
        val description: TextView = view.findViewById(R.id.row_food_description)

        init {
            // layout の初期設定をする場合
//            image = view.findViewById(R.id.row_food_image)
        }
    }

    // レイアウトの設定
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_food, viewGroup, false)
        return ViewHolder(view)
    }

    // Viewの設定
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val food = foodList[position]

//        viewHolder.image.setImageResource(animal.imageId)
        viewHolder.name.text = food.name
        viewHolder.description.text = food.description
    }

    // 表示数を返す
    override fun getItemCount() = foodList.size
}