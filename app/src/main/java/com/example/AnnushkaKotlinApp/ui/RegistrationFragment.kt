package com.example.AnnushkaKotlinApp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.AnnushkaKotlinApp.R
import com.example.AnnushkaKotlinApp.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    var regfragmentbinding: FragmentRegistrationBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        regfragmentbinding = FragmentRegistrationBinding.bind(view)

        regfragmentbinding?.backtologin?.setOnClickListener {
            parentFragmentManager.commit {
                replace<LoginFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }
    }
}