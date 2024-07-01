package com.example.AnnushkaKotlinApp.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.AnnushkaKotlinApp.data.DataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import com.example.AnnushkaKotlinApp.R
import com.example.AnnushkaKotlinApp.data.Network.MeditationApi
import com.example.AnnushkaKotlinApp.data.Network.MeditationApiServiceImpl
import com.example.AnnushkaKotlinApp.data.UserLogin
import com.example.AnnushkaKotlinApp.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login) {
    var fragmentLoginBinding: FragmentLoginBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding = FragmentLoginBinding.bind(view)
        val password: EditText = view.findViewById(R.id.editTextTextEmailAddress)
        val email: EditText = view.findViewById(R.id.editTextTextPassword)
        val  service = MeditationApi.retrofitService
        val serviceImpl = MeditationApiServiceImpl(service)
        val dataStore = DataStore(requireContext())
        fragmentLoginBinding?.signIn?.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                val user = UserLogin(email.text.toString(), password.text.toString())
                val TryLogin = serviceImpl.login(user)
                if (TryLogin.isSuccessful)
                {
                    var test = TryLogin.body()
                    if (test != null) {
                        dataStore.setUser(test)
                    };
                    parentFragmentManager.commit {
                        replace<AccountFragment>(R.id.fragment_container_view)
                    }
                }
            }
        }

        fragmentLoginBinding?.signUp?.setOnClickListener {
            parentFragmentManager.commit {
                replace<RegistrationFragment>(R.id.fragment_container_view)
            }

        }
    }
}