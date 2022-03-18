package com.example.food_delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_welcome.*
class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        button_Signin.setOnClickListener {
            val intent: Intent = Intent(this,Login::class.java)
            startActivity(intent)
        }

        button_login3.setOnClickListener {
            val intent: Intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
    }

    fun nextWelcome(view: View) {}
}