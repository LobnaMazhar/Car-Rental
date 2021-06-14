package lobna.c3s.task.ui.details

import android.view.View
import androidx.databinding.ObservableBoolean
import lobna.c3s.task.data.CompanyModel

class CompanyItemViewModel(val item: CompanyModel) {

    val isExpandedObservable = ObservableBoolean(false)

    val carsAdapter = CarInCompanyAdapter(item.cars)

    fun onItemClick(view: View) {
        isExpandedObservable.set(!isExpandedObservable.get())
    }
}