package com.example.simpleexampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleexampleandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter1: UserAdapter
    private lateinit var userAdapter2: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter1 = UserAdapter(applicationContext)
        userAdapter1.submitList(fakeData())

        userAdapter2 = UserAdapter(applicationContext)
        userAdapter2.submitList(fakeData())


        binding.listUser1.apply {
            adapter = userAdapter1
            layoutManager = LinearLayoutManager(applicationContext)
        }

        binding.listUser2.apply {
            adapter = userAdapter2
            layoutManager = LinearLayoutManager(applicationContext)
        }

    }

    fun fakeData(): List<User>{
        val arrayList = ArrayList<User>()
        for (i in 0.. 20){
            val user = User("name $i", i)
            arrayList.add(user)
        }
        return arrayList.toList()
    }
}