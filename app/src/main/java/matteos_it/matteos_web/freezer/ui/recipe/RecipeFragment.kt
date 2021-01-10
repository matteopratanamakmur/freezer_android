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

    // 追加ボタンタップ時に呼ばれる
    override fun buttonTapped(recipe: RecipeData) {
        // TODO tap 時の処理を書く
        print(recipe.name)
    }
}