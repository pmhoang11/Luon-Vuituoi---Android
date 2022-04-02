package com.example.food_delivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.food_delivery.databinding.ActivityRestaurantListBinding

class RestaurantListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurantListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant_list)

        binding.back.setOnClickListener { finish() }

        val data = DataStore.getDataSet()
        val adapter = RestaurantAdapter(data)
        val lm = LinearLayoutManager(this)

        //chuyển đổi linear, grid
        binding.rvRestaurant.layoutManager = lm
        binding.rvRestaurant.adapter = adapter
        binding.linearView.setOnClickListener {
            binding.linearView.setBackgroundResource(R.drawable.bg_switch_item)
            binding.gridView.setBackgroundResource(R.drawable.bg_switch_grid)
            val lm = LinearLayoutManager(this)
            binding.rvRestaurant.layoutManager = lm
            binding.rvRestaurant.adapter = adapter
        }
        binding.gridView.setOnClickListener {
            binding.linearView.setBackgroundResource(R.drawable.bg_switch_linear)
            binding.gridView.setBackgroundResource(R.drawable.bg_switch_item)
            val lm = GridLayoutManager(this, 2)
            binding.rvRestaurant.layoutManager = lm
            binding.rvRestaurant.adapter = adapter
        }
    }

}