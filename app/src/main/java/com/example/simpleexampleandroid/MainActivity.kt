package com.example.simpleexampleandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rcv: RecyclerView
    private lateinit var circleAdapter: CircleAdapter
    private lateinit var circleViewModel : CircleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcv = findViewById(R.id.rcv_list_circle)


        //activity
        /*  @Param: activity
        *
        * */
        circleViewModel = ViewModelProvider(this)[CircleViewModel::class.java]
        circleAdapter = circleViewModel.getData()?.let { CircleAdapter(it) }!! // circleAdapter = circleViewModel.getData()

        rcv.apply {

            adapter = circleAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}
//aplly, get ...kotlin.
