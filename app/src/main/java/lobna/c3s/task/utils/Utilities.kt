package lobna.c3s.task.utils

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.gson.Gson

object Utilities {

    fun showKeyboard(view: View) {
        try {
            val imm =
                view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hideKeyboard(view: View) {
        try {
            val imm =
                view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hideKeyboard(activity: Activity) {
        try {
            val imm =
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(View(activity).windowToken, 0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getJson(o: Any?): String? {
        return Gson().toJson(o)
    }

    fun Any.toJson(): String {
        return Gson().toJson(this)
    }

    fun getObjectFromJson(json: String, c: Class<*>?): Any? {
        return try {
            if (json.isEmpty()) null else Gson().fromJson(json, c)
        } catch (e: java.lang.Exception) {
            null
        }
    }

    fun String.toObjectFromJson(c: Class<*>?): Any? {
        return try {
            if (isEmpty()) null else Gson().fromJson(this, c)
        } catch (e: java.lang.Exception) {
            null
        }
    }
}