package com.example.AnnushkaKotlinApp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.AnnushkaKotlinApp.R
import com.example.AnnushkaKotlinApp.databinding.OnboardingBinding

class OnBoarding : Fragment(R.layout.onboarding) {
    private var binding: OnboardingBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = OnboardingBinding.bind(view)

        binding?.signIn?.setOnClickListener {
            parentFragmentManager.commit {
                replace<LoginFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }

        binding?.signUp?.setOnClickListener {
            parentFragmentManager.commit {
                replace<RegistrationFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}