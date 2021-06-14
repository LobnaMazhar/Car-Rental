package lobna.c3s.task.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import lobna.c3s.task.ui.home.HomeActivity
import lobna.c3s.task.R
import lobna.c3s.task.preferences.LoginSession
import lobna.c3s.task.ui.login.LoginActivity
import lobna.c3s.task.utils.IntentClass

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            if (LoginSession.isLoggedIn(this))
                IntentClass.goToActivity(this, HomeActivity::class.java, clear = true)
            else
                IntentClass.goToActivity(this, LoginActivity::class.java, clear = true)
        }, 3000)
    }
}