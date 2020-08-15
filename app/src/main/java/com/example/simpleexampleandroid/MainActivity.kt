package com.example.simpleexampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rcv: RecyclerView
    private lateinit var circleAdapter: CircleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcv = findViewById(R.id.rcv_list_circle)

        val arrayList = fakeData()
        circleAdapter = CircleAdapter(arrayList)

        rcv.apply {

            adapter = circleAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
    private fun fakeData(): ArrayList<Int>{
        val arrayList = ArrayList<Int>()
        for (i in 0..20){
            val colorId = 3030 + i
            arrayList.add(colorId)
        }
        return arrayList
    }
}