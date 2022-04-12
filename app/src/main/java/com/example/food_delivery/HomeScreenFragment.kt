package com.example.food_delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.food_delivery.R
import com.example.food_delivery.databinding.FragmentHomeScreenBinding


class HomeScreenFragment : Fragment() {
    lateinit var binding : FragmentHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.profilebtn.setOnClickListener{
//            val controller = findNavController()
//            controller.navigate(R.id.action_homeScreenFragment_to_profileFragment)
//            binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant_list)
//
//            //binding.back.setOnClickListener { finish() }
//
//            val data = DataStore.getDataSet()
//            val adapter = RestaurantAdapter(data)
//            val lm = LinearLayoutManager(this)
//
//            //chuyển đổi linear, grid
//            binding.rvRestaurant.layoutManager = lm
//            binding.rvRestaurant.adapter = adapter
//            binding.linearView.setOnClickListener {
//                binding.linearView.setBackgroundResource(R.drawable.bg_switch_item)
//                binding.gridView.setBackgroundResource(R.drawable.bg_switch_grid)
//                val lm = LinearLayoutManager(this)
//                binding.rvRestaurant.layoutManager = lm
//                binding.rvRestaurant.adapter = adapter
//            }
//            binding.gridView.setOnClickListener {
//                binding.linearView.setBackgroundResource(R.drawable.bg_switch_linear)
//                binding.gridView.setBackgroundResource(R.drawable.bg_switch_item)
//                val lm = GridLayoutManager(this, 2)
//                binding.rvRestaurant.layoutManager = lm
//                binding.rvRestaurant.adapter = adapter
//            }
//        }
//    }

}