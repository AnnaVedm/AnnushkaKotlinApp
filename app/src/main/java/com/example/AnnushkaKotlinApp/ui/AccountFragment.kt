package com.example.AnnushkaKotlinApp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.AnnushkaKotlinApp.R
import com.example.AnnushkaKotlinApp.data.DataStore
import com.example.AnnushkaKotlinApp.data.Network.MeditationApi
import com.example.AnnushkaKotlinApp.data.Network.MeditationApiServiceImpl
import com.example.AnnushkaKotlinApp.databinding.FragmentAccountBinding
import com.example.AnnushkaKotlinApp.images.FeelingsRecyclerAdapter
import com.example.AnnushkaKotlinApp.images.QuoteRecyclerAdapter
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AccountFragment : Fragment(R.layout.fragment_account) {
    var accountBinding: FragmentAccountBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        accountBinding = FragmentAccountBinding.bind(view)

        val accountAvatar = view.findViewById<ImageView>(R.id.main_avatar)
        val dataStore  = DataStore(requireContext())
        lifecycleScope.launch {
            dataStore.avatarFlow.collectLatest {
                Picasso.get().load(it).into(accountAvatar)
            }
        }

        val  service = MeditationApi.retrofitService
        val serviceImpl = MeditationApiServiceImpl(service)


        val RecView = view.findViewById<RecyclerView>(R.id.MainRecyclerView)
        lifecycleScope.launch {
            RecView.adapter = FeelingsRecyclerAdapter(serviceImpl.getFeeling().data);
        }

        val RecView2 = view.findViewById<RecyclerView>(R.id.QuoteRec)
        lifecycleScope.launch {
            RecView2.adapter = QuoteRecyclerAdapter(serviceImpl.getQuote().data.toMutableList());
        }

        accountBinding?.mainNavigation?.setOnItemReselectedListener()
        {
            if (it.itemId == R.id.home)
            {
                parentFragmentManager.commit {
                    replace<AccountFragment>(R.id.fragment_container_view)
                }
            }

            else if (it.itemId == R.id.user)
            {
                parentFragmentManager.commit {
                    replace<ProfileFragment>(R.id.fragment_container_view)
                }
            }
        }
    }
}