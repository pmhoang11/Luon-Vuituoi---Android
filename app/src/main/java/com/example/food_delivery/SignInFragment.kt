package com.example.food_delivery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.food_delivery.databinding.FragmentSignInBinding
import com.example.food_delivery.databinding.FragmentSignUpBinding

class SignInFragment : Fragment() {
    lateinit var binding : FragmentSignInBinding
    private lateinit var ViewModel: login_view_model
    private lateinit var userManager: Data_Store
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        ViewModel = ViewModelProvider(this).get(login_view_model::class.java)

        binding.buttonSignup.setOnClickListener {
            val intent: Intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
        binding.buttonVeri.setOnClickListener{
            val email=binding.email.text.toString().trim()
            val password=binding.password.text.toString().trim()
            viewmodel.checkEmailAndPassword(email,password)
            val controller = findNavController()
            controller.navigate(R.id.action_signInFragment_to_homeScreenFragment)
        }
        listenerErrorEvent()
        listenerSuccessEvent()
    }
    private fun listenerSuccessEvent(){
        ViewModel.isSuccessEvent.observe(this){
            if(it){
                if(check()) {
                    Toast.makeText(this, "Successful login !", Toast.LENGTH_SHORT).show()

                }
                else {
                    Toast.makeText(this, "Email and password incorrect !", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun check(): Boolean {
        val email = binding.email.text.toString().trim()
        val password = binding.password.text.toString().trim()
        println("-------------------")
        println(email)
        println(password)
        println("-------------------")
        val email1 = Data_Store.USER_EMAIL_KEY
        val password1 = Data_Store.USER_PASS_KEY
        println(email1)
        println(password1)
        if (email.equals(email1) && password.equals(password1)) return true
        return false
    }

    private fun listenerErrorEvent(){
        ViewModel.isErrorEvent.observe(this){
            Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
        }
    }



}