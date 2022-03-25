package com.example.food_delivery

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*


class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val email: String? = intent.getStringExtra("email")
        val name: String? = intent.getStringExtra("fullname")
        email_show.setText(email)
        full_name_show.setText(name)
        full_name_view.setText(name)
        phone_number_show.setText(Data_Store.USER_PHONE_KEY)

        //edit full name
        full_name_show.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_namefull,null)
            val fn:EditText = dialogLayout.findViewById(R.id.dialog_name)
            with(builder){
                setTitle("Enter your full name")
                setPositiveButton("Save"){
                    dialog,which -> full_name_show.text=fn.text.toString()
                    full_name_view.text=fn.text.toString()
                }
                setNegativeButton("Cancel"){_,_ ->}
                setView(dialogLayout)
                builder.show()
            }

        }

        //edit email
        email_show.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_email,null)
            val fn:EditText = dialogLayout.findViewById(R.id.dialog_email)
            with(builder){
                setTitle("Enter your email")
                setPositiveButton("Save"){
                        dialog,which -> email_show.text=fn.text.toString()
                }
                setNegativeButton("Cancel"){_,_ ->}
                setView(dialogLayout)
                builder.show()
            }

        }
        //edit phone
        phone_number_show.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_phone,null)
            val fn:EditText = dialogLayout.findViewById(R.id.dialog_phone)
            with(builder){
                setTitle("Enter your phone number")
                setPositiveButton("Save"){
                        dialog,which -> phone_number_show.text=fn.text.toString()
                }
                setNegativeButton("Cancel"){_,_ ->}
                setView(dialogLayout)
                builder.show()
            }

        }

    }
}

