package lobna.c3s.task.repository

import android.content.Context
import lobna.c3s.task.data.CarModel
import lobna.c3s.task.data.CarRecords
import lobna.c3s.task.utils.Utilities.toObjectFromJson
import java.nio.charset.Charset

object DetailsRepository {

    fun getCars(context: Context, category: String): List<CarModel> {
        var json = ""
        try {
            val inputStream = context.assets.open("carsRecords.json")

            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            json = String(buffer, Charset.forName("UTF-8"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (json.isNotBlank()) {
            val cars = json.toObjectFromJson(CarRecords::class.java) as CarRecords

            return cars.data.filter { it.style == category }
        }
        return emptyList()
    }
}