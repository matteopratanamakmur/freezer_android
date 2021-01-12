package matteos_it.matteos_web.freezer.ui.freezer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import matteos_it.matteos_web.freezer.R


class FreezerRecycleViewAdapter(private val freezerList: List<FreezerData>, private val listener: AddFreezerListener): RecyclerView.Adapter<FreezerRecycleViewAdapter.ViewHolder>() {

    // Viewの初期化
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val image: ImageView
        val foodId: TextView = view.findViewById(R.id.row_freezer_food_id)
        val num: TextView = view.findViewById(R.id.row_freezer_num)
        var row: LinearLayout = view.findViewById(R.id.row_freezer_row)
    }

    // レイアウトの設定
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_freezer, viewGroup, false)
        return ViewHolder(view)
    }

    // Viewの設定
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val freezer = freezerList[position]

//        viewHolder.image.setImageResource(animal.imageId)
        viewHolder.foodId.text = freezer.foodId.toString()
        viewHolder.num.text = freezer.num.toString()

        // 行を tap した際の挙動を追加
        viewHolder.row.setOnClickListener {
            listener.buttonTapped(freezer)
        }
    }

    // 表示数を返す
    override fun getItemCount() = freezerList.size
}