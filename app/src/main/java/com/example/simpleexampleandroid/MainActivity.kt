package com.example.simpleexampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.simpleexampleandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val mainActivityViewModel = MainActivityViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        mainActivityViewModel = MainActivityViewModel()
        //run tren luong khac
        mainActivityViewModel.setValue()

        val textObserver = Observer<ButtonUiModel> {
            binding.textview.text = it.name
        }

        binding.button.setOnClickListener {
            mainActivityViewModel.testButton.observe(this, textObserver)
        }





    }

}