package com.example.simpleexampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mva2.adapter.ItemSection
import mva2.adapter.ListSection
import mva2.adapter.MultiViewAdapter
import mva2.adapter.util.Mode

class MainActivity : AppCompatActivity() {
    private lateinit var rcv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcv = findViewById(R.id.listUser)

        val multiAdapter = MultiViewAdapter()
        multiAdapter.registerItemBinders(UserAdapter(), HeaderAdapter())

        val nameList1 : ItemSection<String> = ItemSection("List 1")
        val list1 : ListSection<User> = ListSection()
        list1.addAll(fakeData())

        val nameList2 : ItemSection<String> = ItemSection("List 2")
        val list2 : ListSection<User> = ListSection()
        list2.addAll(fakeData())

        multiAdapter.addSection(nameList1)
        multiAdapter.addSection(list1)
        multiAdapter.addSection(nameList2)
        multiAdapter.addSection(list2)

        multiAdapter.setSelectionMode(Mode.SINGLE)

        rcv.apply {
            adapter = multiAdapter
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
            Log.d("check","build ok")
        }
    }

    fun fakeData(): List<User>{
        val arrayList = ArrayList<User>()
        for (i in 0.. 10){
            val user = User("name user $i", i)
            arrayList.add(user)
        }
        return arrayList.toList()
    }
}