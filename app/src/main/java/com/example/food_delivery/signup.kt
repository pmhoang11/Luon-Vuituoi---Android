package com.example.food_delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.food_delivery.databinding.ActivityLoginBinding
import com.example.food_delivery.databinding.ActivitySignupBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class signup : AppCompatActivity() {
    private lateinit var binding : ActivitySignupBinding
    private lateinit var ViewModel: signup_view_model
    private lateinit var userManager: Data_Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_signup)
        ViewModel= ViewModelProvider(this).get(signup_view_model::class.java)
        userManager = Data_Store(this)
        binding.buttonLogin2.setOnClickListener{
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
        binding.buttonVeri2.setOnClickListener{
            val email=binding.emailSignup.text.toString().trim()
            val password=binding.passwordSignup.text.toString().trim()
            ViewModel.checkEmailAndPassword(email,password)
        }
        listennerSuccessEvent()
        listennerErrorEvent()

    }
    private fun listennerSuccessEvent(){
        ViewModel.isSuccessEvent.observe(this){ isSuccess->
            if(isSuccess){
                val intent=Intent(this, Login::class.java)
                CoroutineScope(Dispatchers.IO).launch {
                    userManager.changedataUser(
                        binding.nameSignup.text.toString().trim(),
                        binding.emailSignup.text.toString().trim(),
                        binding.passwordSignup.text.toString().trim()
                    )
                }
                Toast.makeText( this,"Successful", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
    }
    private fun listennerErrorEvent(){
        ViewModel.isErrorEvent.observe(this){errMsg ->
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Invalid information")
            dialog.setMessage(errMsg)
            dialog.show()
        }
    }


}