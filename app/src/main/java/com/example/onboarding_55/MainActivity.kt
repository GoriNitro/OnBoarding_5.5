package com.example.onboarding_55

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onboarding_55.databinding.ActivityMainBinding
import com.example.onboarding_55.onboarding.OnBoardingFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        isOnboardingDisplayed()
    }
    private fun isOnboardingDisplayed() {
        val appContext: Context = applicationContext
        val myModule = Module(appContext)
        if (!myModule.isOnboardingShown()) {
            supportFragmentManager.beginTransaction().add(R.id.container, OnBoardingFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction().add(R.id.container, TestFragment()).commit()
        }
    }
}