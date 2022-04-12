package com.example.food_delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.food_delivery.databinding.FragmentOnBoardingOneBinding
import com.example.food_delivery.databinding.FragmentOnBoardingTwoBinding


class OnBoardingTwoFragment : Fragment() {
    lateinit var binding : FragmentOnBoardingTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingTwoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOnBoarding2.setOnClickListener{
            var controler = findNavController()
            controler.navigate(R.id.action_onBoardingTwoFragment_to_onBoardingThreeFragment,)
        }
    }

}

