package lobna.c3s.task.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import lobna.c3s.task.data.Reservation
import lobna.c3s.task.database.dao.ReservationDao

@Database(entities = [Reservation::class], version = 1)
abstract class MyRoomDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: MyRoomDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: getInstance(context).also { instance = it }
        }

        private fun getInstance(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, MyRoomDatabase::class.java, "car_rental"
            ).build()

    }

    abstract fun reserve(): ReservationDao
}