package com.example.food_delivery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.food_delivery.databinding.FragmentHomeScreenBinding
import kotlinx.android.synthetic.main.fragment_profile.*


class HomeScreenFragment : Fragment() {
    lateinit var binding : FragmentHomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profilebtn.setOnClickListener{
            val controller = findNavController()
            controller.navigate(R.id.action_homeScreenFragment_to_profileFragment)
           // binding = DataBindingUtil.setContentView(binding.root.context, R.layout.activity_restaurant_list)
        }
        binding.back.setOnClickListener {
//            val fm: FragmentManager = requireActivity().supportFragmentManager
//            for (i in 0 until fm.backStackEntryCount) {
//                fm.popBackStack()
//            }
        }
        val data = DataStore.getDataSet()
        val adapter = RestaurantAdapter(data)
        val lm = LinearLayoutManager(binding.root.context)

        //chuyển đổi linear, grid
        binding.rvRestaurant.layoutManager = lm
        binding.rvRestaurant.adapter = adapter
        binding.linearView.setOnClickListener {
            binding.linearView.setBackgroundResource(R.drawable.bg_switch_item)
            binding.gridView.setBackgroundResource(R.drawable.bg_switch_grid)
            val lm = LinearLayoutManager(binding.root.context)
            binding.rvRestaurant.layoutManager = lm
            binding.rvRestaurant.adapter = adapter
            }
        binding.gridView.setOnClickListener {
            binding.linearView.setBackgroundResource(R.drawable.bg_switch_linear)
            binding.gridView.setBackgroundResource(R.drawable.bg_switch_item)
            val lm = GridLayoutManager(binding.root.context, 2)
            binding.rvRestaurant.layoutManager = lm
            binding.rvRestaurant.adapter = adapter
            }
        }
    }

