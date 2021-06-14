package lobna.c3s.task.data

data class CarRecords(
    val data: ArrayList<CarModel>
)

data class CarModel(
    val car_company: String,
    val logo: String,
    val car_model: String,
    val style: String,
    val year: String,
    val price: String,
    val car_Img: String,
    val is_Available: Boolean
)

data class CompanyModel(
    val car_company: String,
    val logo: String,
    val cars: List<CarModel>
)