package lobna.c3s.task.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import lobna.c3s.task.data.Reservation

@Dao
interface ReservationDao {
    @Insert
    suspend fun insert(reservation: Reservation)

    @Query("Select * from Reservation")
    suspend fun read(): List<Reservation>
}