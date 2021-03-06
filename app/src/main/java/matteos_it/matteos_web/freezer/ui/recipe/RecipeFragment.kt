package matteos_it.matteos_web.freezer.ui.recipe

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

class RecipeFragment : Fragment(), AddRecipeListener {

    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        recipeViewModel =
                ViewModelProvider(this).get(RecipeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recipe, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.fragment_recipe_recycler)
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        recipeViewModel.recipeData.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = RecipeRecycleViewAdapter(it, this)
        })
        return root
    }

    // ボタンタップ時に呼ばれる
    override fun buttonTapped(recipe: RecipeData) {
        // 詳細画面フラグメント
        val recipeDetailFragment = RecipeDetailFragment()
        // 渡すデータ
        val bundle = Bundle()
        bundle.putString("name", recipe.name)
        bundle.putString("description", recipe.description)
        bundle.putString("foodNums", recipe.foodNums)
        recipeDetailFragment.arguments = bundle;
        // 詳細画面に遷移
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.nav_host_fragment, recipeDetailFragment)
        fragmentTransaction.commit()
    }
}