package com.example.simpleexampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleexampleandroid.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter1: UserAdapter
    private lateinit var userAdapter2: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter1 = UserAdapter()
        userAdapter1.submitList(fakeData1())

        userAdapter2 = UserAdapter()
        userAdapter2.submitList(fakeData2())


        binding.listUser1.apply {
            adapter = userAdapter1
            layoutManager = LinearLayoutManager(applicationContext)
        }

        binding.listUser2.apply {
            adapter = userAdapter2
            layoutManager = LinearLayoutManager(applicationContext)
        }
        userAdapter1.listener = {
            val user1 = userAdapter1.updateCurrent()
            if (user1 != null && it != -1){
                userAdapter2.updateSelection ={ user2 ->
                    user2 == user1
                }
                userAdapter2.notifyDataSetChanged()
                userAdapter2.checkedPosition = -1
            }
        }
        userAdapter2.listener = { it ->
            val user2 = userAdapter2.updateCurrent()
            if (user2 != null && it != -1){
                userAdapter1.updateSelection ={ user1 ->
                    user1 == user2
                }
                userAdapter1.notifyDataSetChanged()
                userAdapter1.checkedPosition = -1
            }
        }
    }

    fun fakeData1(): List<User>{
        val arrayList = ArrayList<User>()
        for (i in 0.. 20){
            val user = User("name a1 $i", i)
            arrayList.add(user)
        }
        return arrayList.toList()
    }

    fun fakeData2(): List<User>{
        val arrayList = ArrayList<User>()
        for (i in 0.. 20){
            val user = User("name a2 $i", i)
            arrayList.add(user)
        }
        return arrayList.toList()
    }
}