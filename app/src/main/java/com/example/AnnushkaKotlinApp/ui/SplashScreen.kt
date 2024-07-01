package com.example.AnnushkaKotlinApp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.example.AnnushkaKotlinApp.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : Fragment(R.layout.splashscreen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       lifecycleScope.launch(Dispatchers.IO) {
           delay(3000)
           parentFragmentManager.commit {
               add<OnBoarding>(R.id.fragment_container_view)
           }
       }
    }
}