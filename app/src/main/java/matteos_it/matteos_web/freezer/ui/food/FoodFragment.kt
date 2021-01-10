package matteos_it.matteos_web.freezer.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import matteos_it.matteos_web.freezer.R

class FoodFragment : Fragment(), AddFoodListener {

    private lateinit var foodViewModel: FoodViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        foodViewModel =
                ViewModelProvider(this).get(FoodViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_food, container, false)
        // 一覧表示（recycler view）
        val recyclerView: RecyclerView = root.findViewById(R.id.fragment_food_recycler)
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        foodViewModel.foodData.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = FoodRecycleViewAdapter(it, this)
        })
        return root
    }

    // 追加ボタンタップ時に呼ばれる
    override fun buttonTapped(food: FoodData) {
        // TODO tap 時の処理を書く
        print(food.name)
    }
}