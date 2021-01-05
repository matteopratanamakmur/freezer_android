package matteos_it.matteos_web.freezer.ui.freezer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FreezerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is freezer Fragment"
    }
    val text: LiveData<String> = _text
}