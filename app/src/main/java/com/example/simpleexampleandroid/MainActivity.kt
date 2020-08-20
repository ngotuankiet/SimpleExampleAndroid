package com.example.simpleexampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.simpleexampleandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        mainActivityViewModel = MainActivityViewModel()
        //run tren luong khac

        lifecycleScope.launch {
            mainActivityViewModel.setValue()
        }
        binding.button.setOnClickListener {
            mainActivityViewModel.testButton.observe(this, Observer {
                it.name = "kiet"
                it.onClick(

                )
            })
        }

//        findViewById<Button>(R.id.btn_set_text).setOnClickListener{
//            mainActivityViewModel.testLiveData.observe(this, Observer {
//                it.getContentIfNotHandled()?.let {content ->
//                    findViewById<TextView>(R.id.tv_hello_word).text = content
//                }
//
//            })
//        }

        setContentView(binding.root)
    }

}