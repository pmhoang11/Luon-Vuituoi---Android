package com.example.food_delivery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.datastore.dataStore
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.food_delivery.databinding.FragmentSignUpBinding
import com.example.food_delivery.databinding.FragmentWelcomBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class SignUpFragment : Fragment() {
    lateinit var binding : FragmentSignUpBinding
    private lateinit var ViewModel: signup_view_model
  //  lateinit var userManager: Data_Store
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModel= ViewModelProvider(this).get(signup_view_model::class.java)
//        userManager = Data_Store(this)

        binding.buttonLogin2.setOnClickListener {
            val controler = findNavController()
            controler.navigate(R.id.action_signUpFragment_to_signInFragment)
        }
        binding.buttonVeri2.setOnClickListener {
            val email=binding.emailSignup.text.toString().trim()
            val password=binding.passwordSignup.text.toString().trim()
            ViewModel.checkEmailAndPassword(email,password)

        }
        listenerSuccessEvent()
        listenerErrorEvent()

    }

    private fun listenerSuccessEvent(){
        ViewModel.isSuccessEvent.observe(viewLifecycleOwner){
            if(it){
                val fullName = binding.nameSignup.text.toString().trim()
                val email = binding.emailSignup.text.toString().trim()
                val password = binding.passwordSignup.text.toString().trim()
                val user = User(fullName, email, password)
                DataAccount.listUser.add(user)
//                CoroutineScope(Dispatchers.IO).launch {
//                    userManager.changedataUser(
//                        binding.nameSignup.text.toString().trim(),
//                        binding.emailSignup.text.toString().trim(),
//                        binding.passwordSignup.text.toString().trim()
//                    )
//                }
//                _DataStore(binding.nameSignup.text.toString().trim(),
//                    binding.emailSignup.text.toString().trim(),
//                    binding.passwordSignup.text.toString().trim())

                Toast.makeText( activity,"Successful", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
            }
        }
    }
    private fun listenerErrorEvent(){
        ViewModel.isErrorEvent.observe(viewLifecycleOwner){errMsg ->
            val dialog = AlertDialog.Builder(requireContext())
            dialog.setTitle("Invalid information")
            dialog.setMessage(errMsg)
            dialog.show()
        }
    }

}