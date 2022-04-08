package com.example.food_delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.food_delivery.databinding.FragmentOnBoardingThreeBinding
import com.example.food_delivery.databinding.FragmentOnBoardingTwoBinding


class OnBoardingThreeFragment : Fragment() {
    lateinit var binding : FragmentOnBoardingThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding_three, container, false)
    }

}