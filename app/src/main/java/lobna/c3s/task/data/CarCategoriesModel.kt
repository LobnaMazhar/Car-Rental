package lobna.c3s.task.data

import android.os.Parcel
import android.os.Parcelable

data class CarCategoriesModel(
    val data: ArrayList<CarCategories>
)

data class CarCategories(
    val category: String?,
    val image_name: String?,
    val description: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(category)
        parcel.writeString(image_name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CarCategories> {
        override fun createFromParcel(parcel: Parcel): CarCategories {
            return CarCategories(parcel)
        }

        override fun newArray(size: Int): Array<CarCategories?> {
            return arrayOfNulls(size)
        }
    }
}