package com.kelvinchan.baseapp.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.kelvinchan.baseapp.exception.ManagerException

class SharedPrefManager : Clearable {

    fun put(key: String, `val`: Boolean) {
        val editor = sharedPreferences!!.edit()
        editor.putBoolean(key, `val`)
        editor.apply()
    }

    fun getBool(key: String, defaultVal: Boolean): Boolean {
        return sharedPreferences!!.getBoolean(key, defaultVal)
    }

    fun setBool(key: String, `val`: Boolean) {
        val editor = sharedPreferences!!.edit()
        editor.putBoolean(key, `val`)
        editor.apply()
    }

    fun setString(key: String, `val`: String) {
        val editor = sharedPreferences!!.edit()
        editor.putString(key, `val`)
        editor.apply()
    }

    fun setStringImmediate(key: String, `val`: String): Boolean {
        val editor = sharedPreferences!!.edit()
        editor.putString(key, `val`)
        return editor.commit()
    }

    fun getString(key: String, defaultVal: String): String? {
        return sharedPreferences!!.getString(key, defaultVal)
    }

    fun setLong(key: String, `val`: Long) {
        val editor = sharedPreferences!!.edit()
        editor.putLong(key, `val`)
        editor.apply()
    }

    fun getLong(key: String, defaultVal: Long): Long {
        return sharedPreferences!!.getLong(key, defaultVal)
    }

    fun removePreference(key: String) {
        val editor = sharedPreferences!!.edit()
        editor.remove(key).apply()
    }

    override fun clearAll() {
        val editor = sharedPreferences!!.edit()
        editor.clear().apply()
    }

    companion object {
        private var sharedPreferences: SharedPreferences? = null
        private val sharedPrefManager = SharedPrefManager()

        fun initialize(applicationContext: Context) {
            if (sharedPreferences == null) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext.applicationContext)
            }
        }

        val sharedPrefInstance: SharedPrefManager
            @Throws(ManagerException::class)
            get() {
                if (sharedPreferences == null) {
                    throw ManagerException("Shared pref not initialized")
                }
                return sharedPrefManager
            }
    }
}