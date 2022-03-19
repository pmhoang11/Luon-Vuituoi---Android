package com.example.food_delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_on_boarding_one.*


class OnBoardingOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_one)
        btn_onBoarding1.setOnClickListener {
            val intent: Intent = Intent(this, OnBoardingTwoActivity::class.java)
            startActivity(intent)
        }

    }

}