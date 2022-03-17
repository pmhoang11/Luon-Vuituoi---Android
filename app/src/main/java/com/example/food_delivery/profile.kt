package com.example.food_delivery

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.chage_info_dialog.*
import kotlinx.android.synthetic.main.chage_info_dialog.view.*

class profile : AppCompatActivity() {
    val fullname = "NULL"
    val phonenumber = "NULL"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val email: String? = intent.getStringExtra("email")
        val password: String? = intent.getStringExtra("password")
        email_show.setText(email)
        edit_profile.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.chage_info_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Change Information")
            val mAlertDialog = mBuilder.show()
            mDialogView.btn_save.setOnClickListener {
                mAlertDialog.dismiss()
                val name = mDialogView.full_name_change.text.toString()
                val email = mDialogView.change_email.text.toString()
                val phone = mDialogView.phone_number_change.text.toString()
                full_name_show.setText(name)
                email_show.setText(email)
                phone_number_show.setText(phone)

                mDialogView.btn_exit.setOnClickListener {
                    mAlertDialog.dismiss()
                }
            }
        }
    }
}

