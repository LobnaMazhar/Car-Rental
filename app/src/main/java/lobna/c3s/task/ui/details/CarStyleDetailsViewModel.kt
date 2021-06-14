package lobna.c3s.task.ui.details

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lobna.c3s.task.data.CarCategories
import lobna.c3s.task.data.CarModel
import lobna.c3s.task.repository.DetailsRepository
import lobna.c3s.task.utils.SingleLiveEvent

class CarStyleDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val isGridObservable = ObservableField<Boolean>()
    val styleObservable = ObservableField<CarCategories>()
    val countObservable = ObservableField<String>()
    val adapterObservable = ObservableField<RecyclerView.Adapter<*>>()
    val layoutManagerObservable = ObservableField<RecyclerView.LayoutManager>()

    val backClick = SingleLiveEvent<Boolean>()

    val onBackClicked: () -> Unit = { backClick.postValue(true) }

    private val cars = ArrayList<CarModel>()
    private val carAdapter = CarAdapter(cars)

    private val companies = HashMap<String, MutableList<CarModel>>()
    private val companyAdapter = CompanyAdapter(companies)

    fun init(style: CarCategories?) {
        style?.run {
            styleObservable.set(this)
            getCars(category ?: "")
        }
    }

    fun grid() {
        if (isGridObservable.get() == true) return
        isGridObservable.set(true)
        carAdapter.notifyDataSetChanged()
        adapterObservable.set(carAdapter)
        layoutManagerObservable.set(GridLayoutManager(getApplication(), 2))
    }

    fun list() {
        if (isGridObservable.get() == false) return
        isGridObservable.set(false)
        companyAdapter.notifyDataSetChanged()
        adapterObservable.set(companyAdapter)
        layoutManagerObservable.set(LinearLayoutManager(getApplication()))
    }

    private fun getCars(category: String) {
        cars.addAll(DetailsRepository.getCars(getApplication(), category))

        cars.groupByTo(companies, { it.car_company }, { it })

        countObservable.set(cars.size.toString())
        grid()
    }
}