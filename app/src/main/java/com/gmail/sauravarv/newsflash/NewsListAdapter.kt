package com.gmail.sauravarv.newsflash

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val listener : NewsItemClicked) : RecyclerView.Adapter<NewsViewHolder>()
{
    private val items : ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder = NewsViewHolder(view)
        //adding listener for handling clicks of items
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int)
    {
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
    }

    override fun getItemCount(): Int
    {
        return items.size
    }

    fun updateNews(updatedNews : ArrayList<News>)
    {
        items.clear()
        items.addAll(updatedNews)
        notifyDataSetChanged()
    }

}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val titleView : TextView = itemView.findViewById(R.id.item_title)
}

//making callback so that main activity will know about the onClickListener used in the adapter.
interface NewsItemClicked
{
    fun onItemClicked(item : News)
}
