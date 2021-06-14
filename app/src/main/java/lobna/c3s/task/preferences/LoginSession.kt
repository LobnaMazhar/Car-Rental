package lobna.c3s.task.preferences

import android.content.Context
import android.content.SharedPreferences
import lobna.c3s.task.ui.SplashActivity
import lobna.c3s.task.utils.IntentClass

object LoginSession {

    private const val USER_DATA_KEY = "user_data"
    private const val IS_LOGIN_KEY = "is_login"

    private lateinit var loginFile: SharedPreferences

    private fun initLoginSession(context: Context) {
        loginFile = context.getSharedPreferences("loginFile", Context.MODE_PRIVATE)
    }

    fun setUserData(context: Context, user: String? = null) {
        initLoginSession(context)
        val editor = loginFile.edit()

        editor.putString(USER_DATA_KEY, user)

        editor.putBoolean(IS_LOGIN_KEY, true)

        editor.apply()
    }

    fun getUserData(context: Context): String? {
        initLoginSession(context)

        return loginFile.getString(USER_DATA_KEY, null)
    }

    fun isLoggedIn(context: Context): Boolean {
        initLoginSession(context)

        return loginFile.getBoolean(IS_LOGIN_KEY, false)
    }

    fun clearData(context: Context, restart: Boolean = false) {
        initLoginSession(context)

        loginFile.edit().clear().apply()

        if (restart)
            IntentClass.goToActivity(context, SplashActivity::class.java, clear = true)
    }
}
