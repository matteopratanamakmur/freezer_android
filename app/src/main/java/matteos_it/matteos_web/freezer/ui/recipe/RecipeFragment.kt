package matteos_it.matteos_web.freezer.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import matteos_it.matteos_web.freezer.R

class RecipeFragment : Fragment() {

    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        recipeViewModel =
                ViewModelProvider(this).get(RecipeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recipe, container, false)
        val textView: TextView = root.findViewById(R.id.text_recipe)
        recipeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}