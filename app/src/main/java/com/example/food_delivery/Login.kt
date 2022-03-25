package com.example.food_delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.food_delivery.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_welcome.*
class Login : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var viewmodel: login_view_model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        viewmodel = ViewModelProvider(this).get(login_view_model::class.java)

        binding.buttonSignup.setOnClickListener {
            val intent: Intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
        binding.buttonVeri.setOnClickListener {
            val email=binding.email.text.toString().trim()
            val password=binding.password.text.toString().trim()
            viewmodel.checkEmailAndPassword(email,password)
        }
        listenerErrorEvent()
        listenerSuccessEvent()
    }
    private fun listenerSuccessEvent(){
        viewmodel.isSuccessEvent.observe(this){
            if(it){
                val email = binding.email.text.toString().trim()
                val password = binding.password.text.toString().trim()
                if(email.equals("ronaldo@gmail.com")&& password.equals("123456")) {
                    Toast.makeText(this, "Successful login !", Toast.LENGTH_SHORT).show()

                    val intent: Intent = Intent(this, profile::class.java)
                    intent.putExtra("email", email)
                    intent.putExtra("password", password)
                    startActivity(intent)
                }

            }
        }
    }

    private fun listenerErrorEvent(){
        viewmodel.isErrorEvent.observe(this){
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
    }

}