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

    // ボタンタップ時に呼ばれる
    override fun buttonTapped(food: FoodData) {
        // 詳細画面フラグメント
        val foodDetailFragment = FoodDetailFragment()
        // 渡すデータ
        val bundle = Bundle()
        bundle.putString("name", food.name)
        bundle.putString("description", food.description)
        foodDetailFragment.arguments = bundle;
        // 詳細画面に遷移
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.nav_host_fragment, foodDetailFragment)
        fragmentTransaction.commit()
    }
}