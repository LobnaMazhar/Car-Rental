package lobna.c3s.task.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Reservation(
    @ColumnInfo val date: String,
    @ColumnInfo val days: Int,
    @ColumnInfo val car_company: String,
    @ColumnInfo val logo: String,
    @ColumnInfo val car_model: String,
    @ColumnInfo val style: String,
    @ColumnInfo val year: String,
    @ColumnInfo val price: String,
    @ColumnInfo val car_Img: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
)