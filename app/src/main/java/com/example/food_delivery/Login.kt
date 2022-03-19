package com.example.food_delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        button_veri.setOnClickListener(View.OnClickListener {
            if (email.getText().length !=0 && password.getText().toString().length !=0)
            {
                if(email.getText().toString().trim().equals("ronaldo@gmail.com") && password.getText().toString().trim().equals("123456"))
                {
                    Toast.makeText(this , "Successful login !",Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this, profile::class.java)
                    intent.putExtra("email",email.getText().toString().trim())
                    intent.putExtra("password",password.getText().toString().trim())
                    startActivity(intent)
                }else {
                    Toast.makeText(this , "Ivalid email or password!",Toast.LENGTH_SHORT).show()
                }
            }else {
                Toast.makeText(this, "Email and password must be filled in completely!", Toast.LENGTH_SHORT).show()
            }
        })


       /* button_veri.setOnClickListener {
            val intent: Intent = Intent(this, verification::class.java)
            startActivity(intent)
*/

    }
}