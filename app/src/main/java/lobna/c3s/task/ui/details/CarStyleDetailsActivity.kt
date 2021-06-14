package lobna.c3s.task.ui.details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import lobna.c3s.task.databinding.ActivityCarStyleDetailsBinding

class CarStyleDetailsActivity : AppCompatActivity() {

    private val carStyleDetailsViewModel by viewModels<CarStyleDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityCarStyleDetailsBinding = ActivityCarStyleDetailsBinding.inflate(layoutInflater)
        setContentView(activityCarStyleDetailsBinding.root)
        activityCarStyleDetailsBinding.csdvm = carStyleDetailsViewModel

        val bundle = intent.getBundleExtra("data")
        carStyleDetailsViewModel.init(bundle?.getParcelable("style"))

        carStyleDetailsViewModel.backClick.observe(this, { onBackPressed() })
    }
}