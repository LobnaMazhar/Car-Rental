package lobna.c3s.task.repository

import android.content.Context
import lobna.c3s.task.data.CarModel
import lobna.c3s.task.data.Reservation
import lobna.c3s.task.database.MyRoomDatabase

object ReservationRepository {

    suspend fun reserveCar(context: Context, car: CarModel, date: String, days: Int) {
        MyRoomDatabase.invoke(context).reserve().insert(
            Reservation(
                date, days, car.car_company, car.logo, car.car_model,
                car.style, car.year, car.price, car.car_Img
            )
        )
    }

    suspend fun getAll(context: Context): List<Reservation> {
        return MyRoomDatabase.invoke(context).reserve().read()
    }
}