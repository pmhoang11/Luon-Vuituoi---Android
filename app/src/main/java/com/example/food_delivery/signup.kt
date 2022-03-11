package com.example.food_delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_welcome.*

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        button_login2.setOnClickListener {
            val intent: Intent = Intent(this,Login::class.java)
            startActivity(intent)
        }

        button_veri2.setOnClickListener {
            val intent: Intent = Intent(this, verification::class.java)
            startActivity(intent)

        }
    }
}