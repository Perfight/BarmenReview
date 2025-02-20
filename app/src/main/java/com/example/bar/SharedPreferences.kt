package com.example.bar

import android.content.Context
import android.content.SharedPreferences

object SharedPreferences {
    private const val PREF_NAME = "BarPreferences"
    private lateinit var prefs: SharedPreferences

    fun initialize(context: Context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun containsData(): Boolean {
        return prefs.contains("data_set")
    }

    fun setDB() {
        prefs.edit().putBoolean("data_set", true).apply()
    }
}