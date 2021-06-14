package lobna.c3s.task.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import lobna.c3s.task.R
import lobna.c3s.task.data.CarModel
import lobna.c3s.task.data.CompanyModel
import lobna.c3s.task.databinding.ItemCompanyBinding

class CompanyAdapter(private val items: HashMap<String, MutableList<CarModel>>) :
    RecyclerView.Adapter<CompanyAdapter.CarStyleViewHolder>() {

    private val keys = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarStyleViewHolder {
        val itemCompanyBinding: ItemCompanyBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_company, parent, false
        )
        return CarStyleViewHolder(itemCompanyBinding)
    }

    override fun onBindViewHolder(holder: CarStyleViewHolder, position: Int) {
        if (keys.isEmpty())
            keys.addAll(items.keys.toTypedArray())

        holder.bind(items[keys[position]] ?: emptyList())
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CarStyleViewHolder(private var itemCompanyBinding: ItemCompanyBinding) :
        RecyclerView.ViewHolder(itemCompanyBinding.root) {

        fun bind(item: List<CarModel>) {
            if (item.isNotEmpty())
                itemCompanyBinding.civm =
                    CompanyItemViewModel(CompanyModel(item[0].car_company, item[0].logo, item))
        }
    }
}