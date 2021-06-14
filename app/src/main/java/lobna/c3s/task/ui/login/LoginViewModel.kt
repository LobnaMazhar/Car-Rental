package lobna.c3s.task.ui.login

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import lobna.c3s.task.ui.home.HomeActivity
import lobna.c3s.task.R
import lobna.c3s.task.preferences.LoginSession
import lobna.c3s.task.utils.IntentClass
import lobna.c3s.task.utils.Utilities

class LoginViewModel : ViewModel() {

    val usernameObservable = ObservableField<String>()
    val usernameErrorObservable = ObservableField<String>()
    val isLoggedInObservable = ObservableBoolean(false)

    fun login(view: View) {
        Utilities.hideKeyboard(view)

        usernameErrorObservable.set(null)

        val username = usernameObservable.get()

        if (username.isNullOrBlank()) {
            usernameErrorObservable.set(view.context.getString(R.string.invalid_username))
        } else {
            isLoggedInObservable.set(true)
            LoginSession.setUserData(view.context, username)
            Handler(Looper.getMainLooper()).postDelayed({
                IntentClass.goToActivity(view.context, HomeActivity::class.java)
            }, 3000)
        }
    }
}