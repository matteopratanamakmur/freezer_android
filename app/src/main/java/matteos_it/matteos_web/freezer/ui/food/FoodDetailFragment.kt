package matteos_it.matteos_web.freezer.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import matteos_it.matteos_web.freezer.R

class FoodDetailFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.detail_food, container, false)
        // 必要な情報を設定
        val nameView: TextView = root.findViewById(R.id.detail_food_name)
        val descriptionView: TextView = root.findViewById(R.id.detail_food_description)
        val buttonView: Button = root.findViewById(R.id.detail_food_back_button)
        // 値を取り出して設定
        val bundle = arguments
        nameView.text = bundle?.getString("name");
        descriptionView.text = bundle?.getString("description");
        buttonView.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return root
    }
}