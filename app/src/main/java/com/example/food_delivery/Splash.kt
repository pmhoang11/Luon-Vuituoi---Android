package com.example.food_delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)
        image_foodhub.startAnimation(topAnimation)
        image_logo.startAnimation(bottomAnimation)
        luonvuituoi_text.startAnimation(bottomAnimation)


        val splashScreenTimeOut  = 4000;
        val intent = Intent(this@Splash,welcome::class.java)
        Handler().postDelayed({
            startActivity(intent)
            finish()
        },splashScreenTimeOut.toLong())

    }

}