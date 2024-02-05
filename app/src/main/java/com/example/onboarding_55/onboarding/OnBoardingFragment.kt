package com.example.onboarding_55.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onboarding_55.Module
import com.example.onboarding_55.R
import com.example.onboarding_55.TestFragment
import com.example.onboarding_55.databinding.FragmentOnBoardingBinding
import com.example.onboarding_55.onboarding.adapter.OnBoardingAdapter

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private val adapter = OnBoardingAdapter(this::onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
    }

    private fun onClick() {
        val appContext: Context = requireActivity().applicationContext
        val module = Module(appContext)
        module.markOnboardingAsShown()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, TestFragment()).commit()
    }
}