package lobna.c3s.task.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import lobna.c3s.task.R
import lobna.c3s.task.data.CarCategories
import lobna.c3s.task.databinding.ItemCarStyleBinding

class CarStyleAdapter(private val items: ArrayList<CarCategories>) :
    RecyclerView.Adapter<CarStyleAdapter.CarStyleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarStyleViewHolder {
        val itemCarStyleBinding: ItemCarStyleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_car_style, parent, false
        )
        return CarStyleViewHolder(itemCarStyleBinding)
    }

    override fun onBindViewHolder(holder: CarStyleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CarStyleViewHolder(private var itemCarStyleBinding: ItemCarStyleBinding) :
        RecyclerView.ViewHolder(itemCarStyleBinding.root) {

        fun bind(item: CarCategories) {
            itemCarStyleBinding.csivm = CarStyleItemViewModel(item)
        }
    }
}