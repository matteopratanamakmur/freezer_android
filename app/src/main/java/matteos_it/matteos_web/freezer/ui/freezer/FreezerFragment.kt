package matteos_it.matteos_web.freezer.ui.freezer

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


class FreezerFragment : Fragment(), AddFreezerListener {

    private lateinit var freezerViewModel: FreezerViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        freezerViewModel =
                ViewModelProvider(this).get(FreezerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_freezer, container, false)
        // 一覧表示（recycler view）
        val recyclerView: RecyclerView = root.findViewById(R.id.fragment_freezer_recycler)
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        freezerViewModel.freezerData.observe(viewLifecycleOwner, Observer {
//            val arrayList = arrayListOf<FreezerData>()
//            recyclerView.adapter = FreezerRecycleViewAdapter(arrayList, this)
            recyclerView.adapter = FreezerRecycleViewAdapter(it, this)
        })
        return root
    }

    // 追加ボタンタップ時に呼ばれる
    override fun buttonTapped(freezerData: FreezerData) {
        // TODO 実装
        print("TODO")
//        // 詳細画面に遷移
//        val foodDetailFragment = FoodDetailFragment()
//        val fragmentTransaction = parentFragmentManager.beginTransaction()
//        fragmentTransaction.addToBackStack(null)
//        fragmentTransaction.replace(R.id.nav_host_fragment, foodDetailFragment)
//        fragmentTransaction.commit()
    }
}