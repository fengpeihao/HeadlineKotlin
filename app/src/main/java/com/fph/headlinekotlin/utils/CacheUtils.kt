package com.fph.headlinekotlin.utils

import android.content.Context
import android.content.SharedPreferences
import com.fph.headlinekotlin.base.App

/**
 * Created by fengpeihao on 2018/1/8.
 */
object CacheUtils {
    private val SP_NAME: String = "sp_cache"
    private val sp: SharedPreferences = App.context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun getString(key: String, defaultValue: String): String {
        return sp.getString(key, defaultValue)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return sp.getInt(key, defaultValue)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sp.getBoolean(key, defaultValue)
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return sp.getLong(key, defaultValue)
    }

    fun putString(key: String, value: String) {
        sp.edit().putString(key, value).apply()
    }

    fun putInt(key: String, value: Int) {
        sp.edit().putInt(key, value).apply()
    }

    fun putLong(key: String, value: Long) {
        sp.edit().putLong(key, value).apply()
    }

    fun putBoolean(key: String, value: Boolean) {
        sp.edit().putBoolean(key, value).apply()
    }
}