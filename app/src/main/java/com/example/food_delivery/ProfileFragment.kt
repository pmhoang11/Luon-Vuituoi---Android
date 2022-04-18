package com.example.food_delivery

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.food_delivery.databinding.FragmentProfileBinding
import com.example.food_delivery.databinding.FragmentSignInBinding
import com.example.food_delivery.databinding.FragmentSignInBindingImpl


class ProfileFragment : Fragment() {
    private lateinit var binding : FragmentProfileBinding
   // private lateinit var binding_login : FragmentSignInBinding
    private lateinit var viewModel: profile_view_model
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       // binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        super.onViewCreated(view, savedInstanceState)
        //binding.user = User(Pro.fullname,Pro.email,Pro.phone)
        binding.user = User(DataAccount.listUser.get(0).fullname,DataAccount.listUser.get(0).email,DataAccount.listUser.get(0).phone)
        viewModel = ViewModelProvider(this).get(profile_view_model::class.java)
        binding.editProfile.setOnClickListener { showDialog() }
        //binding.back.setOnClickListener {}
        binding.btnLogOut.setOnClickListener{
            val controller = findNavController()
            controller.navigate(R.id.action_profileFragment_to_welcomFragment)
            Toast.makeText(activity, "Log out!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDialog() {

        val layoutDialog : View = LayoutInflater.from(binding.root.context).inflate(R.layout.chage_info_dialog, null)
        val textName = layoutDialog.findViewById<EditText>(R.id.dialog_fullname)
        textName.setText(binding.fullNameShow.text.toString())
        val textEmail = layoutDialog.findViewById<EditText>(R.id.dialog_email)
        textEmail.setText(binding.emailShow.text.toString())
        val textPhoneNumber = layoutDialog.findViewById<EditText>(R.id.dialog_phone)
        textPhoneNumber.setText(binding.phoneNumberShow.text.toString())

        val builder = androidx.appcompat.app.AlertDialog.Builder(binding.root.context)
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
//        Data_Store.USER_EMAIL_KEY = email
//        Data_Store.USER_NAME_KEY = name
//        Data_Store.USER_PHONE_KEY = phone
    }
    private fun listenerErrorEvent(){
        viewModel.isErrorEvent.observe(viewLifecycleOwner){
            Toast.makeText(binding.root.context,it, Toast.LENGTH_SHORT).show()
        }
    }
//    private fun getUser(){
//        DataAccount.initSharedPref(requireContext())
//        viewModel.getUser()
//    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding = FragmentProfileBinding.inflate(inflater, container, false)
            return binding.root
        }

}