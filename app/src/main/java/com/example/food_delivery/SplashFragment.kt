package com.example.food_delivery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.fragment.findNavController
import com.example.food_delivery.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    lateinit var binding : FragmentSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topAnimation = AnimationUtils.loadAnimation(binding.root.context,R.anim.top_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(binding.root.context,R.anim.bottom_animation)
        binding.imageFoodhub.startAnimation(topAnimation)
        binding.imageLogo.startAnimation(bottomAnimation)
        binding.luonvuituoiText.startAnimation(bottomAnimation)
        Handler().postDelayed({
            var controler = findNavController()
            controler.navigate(R.id.action_splashFragment_to_welcomFragment)
        }, 2000) // 2secs
    }
}