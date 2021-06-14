package lobna.c3s.task.ui.details

import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import lobna.c3s.task.R
import lobna.c3s.task.data.CarModel
import lobna.c3s.task.repository.ReservationRepository
import lobna.c3s.task.utils.Utilities
import java.util.*

class CarItemViewModel(val item: CarModel) : ViewModel() {

    fun onItemClick(view: View) {
        if (item.is_Available) {
            val dialog = BottomSheetDialog(view.context, R.style.BottomSheetDialog)
            dialog.setContentView(R.layout.bottomsheet_select_date)
            dialog.show()
            dialog.dismissWithAnimation = true

            val calendar = Calendar.getInstance()
            calendar.time = Date()

            val datePicker = dialog.findViewById<DatePicker>(R.id.date_picker)
            val daysEditText = dialog.findViewById<EditText>(R.id.days_edit_text)
            val saveButton = dialog.findViewById<Button>(R.id.save_button)

            saveButton?.setOnClickListener {
                val days = daysEditText?.text

                if (days.isNullOrBlank() || days.toString() == "0")
                    daysEditText?.error = "Field required with 1 minimum day(s)"
                else {
                    Utilities.hideKeyboard(it)

                    val date =
                        "${datePicker?.dayOfMonth ?: 0}-${(datePicker?.month ?: 0) + 1}-${datePicker?.year ?: 0}"

                    viewModelScope.launch(Dispatchers.IO) {
                        ReservationRepository.reserveCar(
                            view.context, item, date, days.toString().toInt()
                        )
                        val n = ReservationRepository.getAll(view.context)
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                view.context,
                                "RESERVED, You now have ${n.size} reservations",
                                Toast.LENGTH_LONG
                            )
                                .show()
                            dialog.dismiss()
                        }
                    }
                }
            }
            datePicker?.updateDate(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )

            datePicker?.minDate = Date().time
        }
    }
}