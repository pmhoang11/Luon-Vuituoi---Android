package com.example.food_delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.food_delivery.databinding.FragmentOnBoardingOneBinding
import com.example.food_delivery.databinding.FragmentSplashBinding


class OnBoardingOneFragment : Fragment() {
    lateinit var binding : FragmentOnBoardingOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnOnBoarding1.setOnClickListener{
            var controler = findNavController()
            controler.navigate(R.id.action_onBoardingOneFragment_to_onBoardingTwoFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingOneBinding.inflate(inflater,container,false)
        return binding.root
    }


}