package lobna.c3s.task.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import lobna.c3s.task.R
import lobna.c3s.task.data.CarModel
import lobna.c3s.task.databinding.ItemCarBinding

class CarAdapter(private val items: ArrayList<CarModel>) :
    RecyclerView.Adapter<CarAdapter.CarStyleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarStyleViewHolder {
        val itemCarBinding: ItemCarBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_car, parent, false
        )
        return CarStyleViewHolder(itemCarBinding)
    }

    override fun onBindViewHolder(holder: CarStyleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CarStyleViewHolder(private var itemCarBinding: ItemCarBinding) :
        RecyclerView.ViewHolder(itemCarBinding.root) {

        fun bind(item: CarModel) {
            itemCarBinding.civm = CarItemViewModel(item)
        }
    }
}