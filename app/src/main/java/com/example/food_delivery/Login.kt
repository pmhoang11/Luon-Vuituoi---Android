package com.example.food_delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_welcome.*
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button_Signup.setOnClickListener {
            val intent: Intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
        button_veri.setOnClickListener {
            val intent: Intent = Intent(this, verification::class.java)
            startActivity(intent)

        }
    }
}