package lobna.c3s.task.ui.home

import android.os.Bundle
import android.view.View
import lobna.c3s.task.data.CarCategories
import lobna.c3s.task.ui.details.CarStyleDetailsActivity
import lobna.c3s.task.utils.IntentClass

class CarStyleItemViewModel(val item: CarCategories) {

    fun onItemClick(view: View) {
        val bundle = Bundle()
        bundle.putParcelable("style", item)
        IntentClass.goToActivity(view.context, CarStyleDetailsActivity::class.java, bundle)
    }
}