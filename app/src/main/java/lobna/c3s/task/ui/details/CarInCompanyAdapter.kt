package lobna.c3s.task.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import lobna.c3s.task.R
import lobna.c3s.task.data.CarModel
import lobna.c3s.task.databinding.ItemCarInCompanyBinding

class CarInCompanyAdapter(private val items: List<CarModel>) :
    RecyclerView.Adapter<CarInCompanyAdapter.CarStyleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarStyleViewHolder {
        val itemCarInCompanyBinding: ItemCarInCompanyBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_car_in_company, parent, false
        )
        return CarStyleViewHolder(itemCarInCompanyBinding)
    }

    override fun onBindViewHolder(holder: CarStyleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CarStyleViewHolder(private var itemCarInCompanyBinding: ItemCarInCompanyBinding) :
        RecyclerView.ViewHolder(itemCarInCompanyBinding.root) {

        fun bind(item: CarModel) {
            itemCarInCompanyBinding.civm = CarItemViewModel(item)
        }
    }
}