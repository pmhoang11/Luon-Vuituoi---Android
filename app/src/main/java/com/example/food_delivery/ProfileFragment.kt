package com.example.food_delivery

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.food_delivery.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    lateinit var binding : FragmentProfileBinding
    lateinit var viewModel: profile_view_model
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //binding = DataBindingUtil.setContentView(this, R.layout.fragment_profile)
//        binding.user =
//            User(Data_Store.USER_NAME_KEY, Data_Store.USER_EMAIL_KEY, Data_Store.USER_PHONE_KEY)
//        viewModel = ViewModelProvider(this).get(profile_view_model::class.java)
//        binding.editProfile.setOnClickListener { showDialog() }
////        binding.back.setOnClickListener { finish() }
////        binding.next.setOnClickListener {
////            val intent = Intent(this, HomeScreenFragment::class.java)
////            startActivity(intent)
////        }
//    }


    private fun showDialog() {

        val layoutDialog = layoutInflater.inflate(R.layout.chage_info_dialog, null)
        val textName = layoutDialog.findViewById<EditText>(R.id.dialog_fullname)
        textName.setText(binding.fullNameShow.text.toString())
        val textEmail = layoutDialog.findViewById<EditText>(R.id.dialog_email)
        textEmail.setText(binding.emailShow.text.toString())
        val textPhoneNumber = layoutDialog.findViewById<EditText>(R.id.dialog_phone)
        textPhoneNumber.setText(binding.phoneNumberShow.text.toString())

        val builder = AlertDialog.Builder(requireContext())
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
        viewModel.isSuccessEvent.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                binding.user = User(name, email, phone)
            }
        }
        Data_Store.USER_EMAIL_KEY = email
        Data_Store.USER_NAME_KEY = name
        Data_Store.USER_PHONE_KEY = phone
    }
    private fun listenerErrorEvent(){
        viewModel.isErrorEvent.observe(viewLifecycleOwner){
            Toast.makeText(activity,it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
        binding.user =
            User(Data_Store.USER_NAME_KEY, Data_Store.USER_EMAIL_KEY, Data_Store.USER_PHONE_KEY)
        viewModel = ViewModelProvider(this).get(profile_view_model::class.java)
        binding.editProfile.setOnClickListener { showDialog() }
            binding = FragmentProfileBinding.inflate(inflater, container, false)
            return binding.root
        }

}