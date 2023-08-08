package com.example.cse226classwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class customrecyclerview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customrecyclerview)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)


        recyclerview.layoutManager = LinearLayoutManager(this)


        val data = ArrayList<ItemsViewModel>()


        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.icon_fold, "Item " + i))
        }


        val adapter = CustomAdapter1(data)


        recyclerview.adapter = adapter
    }
}