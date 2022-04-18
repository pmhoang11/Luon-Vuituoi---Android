package com.example.food_delivery

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.food_delivery.databinding.ActivityProfileBinding
import kotlinx.android.synthetic.main.activity_profile.*


class profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: profile_view_model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.user = User(Data_Store.USER_NAME_KEY, Data_Store.USER_EMAIL_KEY, Data_Store.USER_PHONE_KEY)
        viewModel = ViewModelProvider(this).get(profile_view_model::class.java)
        binding.editProfile.setOnClickListener { showDialog() }
        binding.back.setOnClickListener { finish() }
        binding.next.setOnClickListener {
            val intent = Intent(this,RestaurantListActivity::class.java)
            startActivity(intent)
        }
//        setContentView(R.layout.activity_profile)
//        val email: String? = intent.getStringExtra("email")
//        val name: String? = intent.getStringExtra("fullname")
//        email_show.setText(email)
//        full_name_show.setText(name)
//        full_name_view.setText(name)
//        phone_number_show.setText(Data_Store.USER_PHONE_KEY)

//        //edit full name
//        full_name_show.setOnClickListener {
//            val builder = AlertDialog.Builder(this)
//            val inflater = layoutInflater
//            val dialogLayout = inflater.inflate(R.layout.dialog_namefull,null)
//            val fn:EditText = dialogLayout.findViewById(R.id.dialog_name)
//            with(builder){
//                setTitle("Enter your full name")
//                setPositiveButton("Save"){
//                    dialog,which -> full_name_show.text=fn.text.toString()
//                    full_name_view.text=fn.text.toString()
//                }
//                setNegativeButton("Cancel"){_,_ ->}
//                setView(dialogLayout)
//                builder.show()
//            }
//
//        }
//        edit_profile.setOnClickListener {
//            val builder = AlertDialog.Builder(this)
//            val inflater = layoutInflater
//            val dialogLayout = inflater.inflate(R.layout.chage_info_dialog,null)
//            val fn:EditText = dialogLayout.findViewById(R.id.dialog_fullname)
//            with(builder){
//                setTitle("Enter your email")
//                setPositiveButton("Save"){
//                        dialog,which -> email_show.text=fn.text.toString()
//                }
//                setNegativeButton("Cancel"){_,_ ->}
//                setView(dialogLayout)
//                builder.show()
//            }
//
//        }
//        //edit email
//        email_show.setOnClickListener {
//            val builder = AlertDialog.Builder(this)
//            val inflater = layoutInflater
//            val dialogLayout = inflater.inflate(R.layout.dialog_email,null)
//            val fn:EditText = dialogLayout.findViewById(R.id.dialog_email)
//            with(builder){
//                setTitle("Enter your email")
//                setPositiveButton("Save"){
//                        dialog,which -> email_show.text=fn.text.toString()
//                }
//                setNegativeButton("Cancel"){_,_ ->}
//                setView(dialogLayout)
//                builder.show()
//            }
//
//        }
//        //edit phone
//        phone_number_show.setOnClickListener {
//            val builder = AlertDialog.Builder(this)
//            val inflater = layoutInflater
//            val dialogLayout = inflater.inflate(R.layout.dialog_phone,null)
//            val fn:EditText = dialogLayout.findViewById(R.id.dialog_phone)
//            with(builder){
//                setTitle("Enter your phone number")
//                setPositiveButton("Save"){
//                        dialog,which -> phone_number_show.text=fn.text.toString()
//                }
//                setNegativeButton("Cancel"){_,_ ->}
//                setView(dialogLayout)
//                builder.show()
//            }
//
//        }

    }

    private fun showDialog() {

        val layoutDialog : View = LayoutInflater.from(this).inflate(R.layout.chage_info_dialog, null)
        val textName = layoutDialog.findViewById<EditText>(R.id.dialog_fullname)
        textName.setText(binding.fullNameShow.text.toString())
        val textEmail = layoutDialog.findViewById<EditText>(R.id.dialog_email)
        textEmail.setText(binding.emailShow.text.toString())
        val textPhoneNumber = layoutDialog.findViewById<EditText>(R.id.dialog_phone)
        textPhoneNumber.setText(binding.phoneNumberShow.text.toString())

        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
            .setView(layoutDialog)
            .setTitle("Change Information")

        builder.apply {
            setPositiveButton("SAVE", DialogInterface.OnClickListener { _: DialogInterface?, _: Int ->
                viewModel.checkEmail(textEmail.text.toString())
                listenerSuccessEvent(textName.text.toString(), textEmail.text.toString(), textPhoneNumber.text.toString())
                listenerErrorEvent()
            })
            setNegativeButton("CANCEL", DialogInterface.OnClickListener { _: DialogInterface?, _: Int ->

            })
        }
        builder.show()
    }
    private fun listenerSuccessEvent(name: String, email:String, phone:String) {
        viewModel.isSuccessEvent.observe(this) { isSuccess ->
            if (isSuccess) {
                binding.user = User(name, email, phone)
            }
        }
        Data_Store.USER_EMAIL_KEY = email
        Data_Store.USER_NAME_KEY = name
        Data_Store.USER_PHONE_KEY = phone
    }
    private fun listenerErrorEvent(){
        viewModel.isErrorEvent.observe(this){
            Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
        }
    }
}

