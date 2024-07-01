package com.example.AnnushkaKotlinApp.images

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.AnnushkaKotlinApp.R
import com.google.android.material.card.MaterialCardView

class ImagesAdapter() : ListAdapter<Uri, ImagesAdapter.ViewHolder>(ImageViewCallback) {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView : MaterialCardView = view.findViewById(R.id.profile_item_back)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.imageView.setBackgroundDrawable(openInputStream(getItem(position)))
    }


    object ImageViewCallback: DiffUtil.ItemCallback<Uri>() {
        override fun areItemsTheSame(oldItem: Uri, newItem: Uri): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Uri, newItem: Uri): Boolean {
            return oldItem == newItem
        }

    }
}