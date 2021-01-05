package matteos_it.matteos_web.freezer.ui.freezer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import matteos_it.matteos_web.freezer.R

class FreezerFragment : Fragment() {

    private lateinit var freezerViewModel: FreezerViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        freezerViewModel =
                ViewModelProvider(this).get(FreezerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_freezer, container, false)
        val textView: TextView = root.findViewById(R.id.text_freezer)
        freezerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}