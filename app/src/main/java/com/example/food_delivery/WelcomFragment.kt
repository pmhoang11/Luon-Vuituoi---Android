package com.example.food_delivery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.food_delivery.databinding.FragmentOnBoardingOneBinding
import com.example.food_delivery.databinding.FragmentWelcomBinding


class WelcomFragment : Fragment() {

    lateinit var binding : FragmentWelcomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSkip.setOnClickListener {
            var controler = findNavController()
            controler.navigate(R.id.action_welcomFragment_to_signUpFragment)
        }
        binding.buttonLogin3.setOnClickListener {
            var controler = findNavController()
            controler.navigate(R.id.action_welcomFragment_to_signUpFragment)
        }
        binding.buttonSignin.setOnClickListener {
            var controler = findNavController()
            controler.navigate(R.id.action_welcomFragment_to_signUpFragment)
        }
    }

}