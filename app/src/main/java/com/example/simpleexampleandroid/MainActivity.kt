package com.example.simpleexampleandroid

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var btnGetPhoto : Button
    private lateinit var ivPhoto : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGetPhoto = findViewById(R.id.btn_get_photo)
        ivPhoto = findViewById(R.id.iv_photo)

        //set get photo
        btnGetPhoto.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 1){
            val bitmap = data?.extras?.get("data")
            val chosenImageUri : Uri? = data?.data
            val bitmap2 = MediaStore.Images.Media.getBitmap(this.contentResolver, chosenImageUri)
            Log.d("check",bitmap.toString())
            ivPhoto.setImageBitmap(bitmap2)
        }
    }
}