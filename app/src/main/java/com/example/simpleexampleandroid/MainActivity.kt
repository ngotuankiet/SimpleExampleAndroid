package com.example.simpleexampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rcv: RecyclerView
    private lateinit var adapterK: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcv = findViewById(R.id.rcv)
        adapterK = UserAdapter(this)
        adapterK.submitList(fakeList())

        rcv.apply {
            adapter = adapterK
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        }
    }

    private fun fakeList(): ArrayList<User>{
        val arrayList = ArrayList<User>()
        for (i in 0..20 ){
            val user = User("Kiet $i", i)
            arrayList.add(user)
        }
        return arrayList
    }
}