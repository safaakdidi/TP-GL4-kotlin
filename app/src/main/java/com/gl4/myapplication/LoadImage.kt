package com.gl4.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class LoadImage : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var button: Button
    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_image)
        title = "Intent"
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.buttonLoadPicture)
        button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            pickImage.launch(gallery)
        }
    }
    val pickImage= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
        if (result.resultCode==RESULT_OK){
            imageUri = result.data?.data
            imageView.setImageURI(imageUri)
        }
    }


}
