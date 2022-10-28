package com.gl4.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var txtEmail : EditText
    lateinit var txtpwd : EditText
    lateinit var btnLogin : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtEmail = findViewById(R.id.editTextEmail)

txtpwd = findViewById(R.id.editTextPassword)

        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener { view ->
            val duration = Toast.LENGTH_SHORT
            var email = txtEmail.text.toString()
            var pwd = txtpwd.text.toString()
            if((email.equals("gl4@insat.tn")) && (pwd.equals("0000"))){


                val toast = Toast.makeText(applicationContext, "email and password correct", duration)
                toast.show()
                val intent = Intent(this,WelcomeActivity::class.java)

                intent.putExtra("email",email)
                startActivity(intent)
        }else{


                val toast = Toast.makeText(applicationContext, "email $email or password $pwd are incorrect", duration)
                toast.show()
            }

        }




    }
}