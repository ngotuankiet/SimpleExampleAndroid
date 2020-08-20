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
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        mainActivityViewModel = MainActivityViewModel()
        //run tren luong khac
        mainActivityViewModel.setValue()

        val textObserver = Observer<ButtonUiModel> {
            binding.textview.text = it.name
        }

        binding.button.setOnClickListener {
            mainActivityViewModel.testButton.observe(this, Observer {it2 ->
                it2.name = "kiet"
                Log.d("check","test ${it2.name}")
                it2.onClick.let{
                    binding.textview.text = it2.name
                }
            })
        }


        setContentView(binding.root)
    }

}