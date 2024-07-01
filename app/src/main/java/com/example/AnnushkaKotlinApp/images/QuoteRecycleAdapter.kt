package com.example.AnnushkaKotlinApp.images

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.AnnushkaKotlinApp.R
import com.example.AnnushkaKotlinApp.data.Quote
import com.squareup.picasso.Picasso

class QuoteRecyclerAdapter(private val Quote: MutableList<Quote>) :
    RecyclerView.Adapter<QuoteRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img : ImageView = itemView.findViewById(R.id.quotePicture)
        val textDesc : TextView = itemView.findViewById(R.id.quotedescription)
        val textTitle : TextView = itemView.findViewById(R.id.quoteTitle)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.quote_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return Quote.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(Quote[position].image).into(holder.img)
        holder.textTitle.text = Quote[position].title
        holder.textDesc.text = Quote[position].description
    }
}