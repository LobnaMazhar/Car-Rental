package lobna.c3s.task.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import lobna.c3s.task.data.CarCategories
import lobna.c3s.task.repository.HomeRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val items = ArrayList<CarCategories>()
    val carStyleAdapter = CarStyleAdapter(items)

    init {
        items.addAll(HomeRepository.getCarStyles(getApplication()))
        carStyleAdapter.notifyDataSetChanged()
    }

}