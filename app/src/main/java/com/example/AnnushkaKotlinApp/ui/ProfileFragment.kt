package com.example.AnnushkaKotlinApp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.AnnushkaKotlinApp.R
import com.squareup.picasso.Picasso
import com.example.AnnushkaKotlinApp.data.DataStore
import kotlinx.coroutines.launch
import com.example.AnnushkaKotlinApp.databinding.FragmentProfileBinding
import android.provider.MediaStore.Images.Media.getBitmap
import androidx.activity.result.contract.ActivityResultContracts
import com.example.AnnushkaKotlinApp.images.ImagesAdapter
import com.example.AnnushkaKotlinApp.images.MainViewModel
import com.example.AnnushkaKotlinApp.images.Repository
import kotlinx.coroutines.flow.collectLatest

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    var fragmentProfileBinding: FragmentProfileBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentProfileBinding = FragmentProfileBinding.bind(view)
        val ava = view.findViewById<ImageView>(R.id.prof_avatar)
        val NameText = view.findViewById<TextView>(R.id.textProf)
        val dataStore = DataStore(requireContext())
        lifecycleScope.launch {
            dataStore.avatarFlow.collectLatest {
                Picasso.get().load(it).into(ava)
            }
            dataStore.nameFlow.collectLatest {
                NameText.text = it;
            }
        }
        lifecycleScope.launch {
            dataStore.nameFlow.collectLatest {
                NameText.text = it;
            }
        }


        fragmentProfileBinding?.profExit?.setOnClickListener()
        {
            parentFragmentManager.commit {
                replace<LoginFragment>(R.id.fragment_container_view)
            }
        }

        val repository: Repository = Repository(requireContext())
        val viewModel: MainViewModel = MainViewModel(repository)
        val recyclerView = view.findViewById<RecyclerView>(R.id.RecProf)

        val arrayAdapter = ImagesAdapter()
        viewModel.getImages()
        recyclerView.adapter = arrayAdapter
        lifecycleScope.launch {
            viewModel.uris.collect {
                arrayAdapter.submitList(it)
            }
        }
        val photoPicker = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
            val bitmap = getBitmap(requireContext().contentResolver, it!!)
            if (bitmap != null) {
                viewModel.addImage(bitmap)
            }
        }

        fragmentProfileBinding?.navigationView?.setOnItemReselectedListener()
        {
            if (it.itemId == R.id.home)
            {
                parentFragmentManager.commit {
                    replace<AccountFragment>(R.id.fragment_container_view)
                }
            }
            else if (it.itemId == R.id.mus)
            {

            }
            else if (it.itemId == R.id.user)
            {
                parentFragmentManager.commit {
                    replace<AccountFragment>(R.id.fragment_container_view)
                }
            }
        }
    }
}