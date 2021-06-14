package lobna.c3s.task.repository

import android.content.Context
import lobna.c3s.task.data.CarCategories
import lobna.c3s.task.data.CarCategoriesModel
import lobna.c3s.task.utils.Utilities.toObjectFromJson
import java.nio.charset.Charset

object HomeRepository {

    fun getCarStyles(context: Context): ArrayList<CarCategories> {
        var json = ""
        try {
            val inputStream = context.assets.open("CarCategories.json")

            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            json = String(buffer, Charset.forName("UTF-8"))
        } catch (e: Exception) {
            e.printStackTrace()
            return ArrayList()
        }

        return if (json.isNotBlank()) {
            val cars = json.toObjectFromJson(CarCategoriesModel::class.java) as CarCategoriesModel
            cars.data
        } else ArrayList()
    }
}