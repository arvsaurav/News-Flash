package com.gmail.sauravarv.newsflash

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val items : ArrayList<String>, private val listner : NewsItemClicked) : RecyclerView.Adapter<NewsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder = NewsViewHolder(view)
        //adding listner for handling clicks of items
        view.setOnClickListener{
            listner.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int)
    {
        val currentItem = items[position]
        holder.titleview.text = currentItem
    }

    override fun getItemCount(): Int
    {
        return items.size
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val titleview : TextView = itemView.findViewById(R.id.item_title)
}

//making callback so that main activity will know about the onClickListner used in the adapter.
interface NewsItemClicked
{
    fun onItemClicked(item : String)
}
