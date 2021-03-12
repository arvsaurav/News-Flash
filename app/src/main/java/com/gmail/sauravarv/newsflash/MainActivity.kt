package com.gmail.sauravarv.newsflash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NewsItemClicked
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //var my_toolbar : Toolbar = findViewById(R.id.my_toolbar)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        //adding layout manager
        var my_recyclerview : RecyclerView = findViewById(R.id.my_recyclerview)
        my_recyclerview.layoutManager = LinearLayoutManager(this)

        //making instance of adapter
        val items = fetchData()
        val my_adapter = NewsListAdapter(items, this)

        //linking adapter with recycler view
        my_recyclerview.adapter = my_adapter

    }
    private fun fetchData() : ArrayList<String>
    {
        val list = ArrayList<String>()
        for(i in 0 until 50)
        {
            list.add("Item $i")
        }
        return list
    }

    //implementing interface 'NewsItemClicked'
    override fun onItemClicked(item: String)
    {
        Toast.makeText(this, "Clicked item is $item", Toast.LENGTH_LONG).show()
    }

}