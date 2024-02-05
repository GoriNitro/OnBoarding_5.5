package com.example.onboarding_55

import android.content.Context
import android.content.SharedPreferences


class Module(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

    fun isOnboardingShown(): Boolean {
        return sharedPreferences.getBoolean("isOnboardingShown", false)
    }

    fun markOnboardingAsShown() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("isOnboardingShown", true)
        editor.apply()
    }
}

