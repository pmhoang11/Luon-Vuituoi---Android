package com.example.food_delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.food_delivery.databinding.FragmentHomeScreenBinding
import com.example.food_delivery.model.Restaurant

class HomeScreenFragment : Fragment(),RestaurantAdapter.OnItemClickListener {
    private lateinit var binding : FragmentHomeScreenBinding
    private lateinit var viewModel : RestaurantVM
    private lateinit var adapter: RestaurantAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(RestaurantVM::class.java)
        setupMenu()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profilebtn.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_homeScreenFragment_to_profileFragment)
        }

    }
    override fun onStart() {
        super.onStart()
        viewModel.loadData()
    }
//    private fun setupMenu(){
//        //adapter = RestaurantAdapter(this)
//        val lm = LinearLayoutManager(requireContext())
//        binding.rvRestaurant.layoutManager = lm
//        binding.rvRestaurant.adapter = adapter
//       // binding = DataBindingUtil.setContentView(this, R.layout.fragment_home_screen)
//
//        //binding.back.setOnClickListener { finish() }
//
//        val data = DataStore.getDataSet()
//        val adapter = RestaurantAdapter(data)
////            val lm = LinearLayoutManager(this)
//        //val lm = LinearLayoutManager(requireContext())
//
//        //chuyển đổi linear, grid
//        binding.rvRestaurant.layoutManager = lm
//        binding.rvRestaurant.adapter = adapter
//        binding.linearView.setOnClickListener {
//            binding.linearView.setBackgroundResource(R.drawable.bg_switch_item)
//            binding.gridView.setBackgroundResource(R.drawable.bg_switch_grid)
//            val lm = LinearLayoutManager(requireContext())
//            binding.rvRestaurant.layoutManager = lm
//            binding.rvRestaurant.adapter = adapter
//        }
//        binding.gridView.setOnClickListener {
//            binding.linearView.setBackgroundResource(R.drawable.bg_switch_linear)
//            binding.gridView.setBackgroundResource(R.drawable.bg_switch_item)
//            val lm = GridLayoutManager(requireContext(), 2)
//            binding.rvRestaurant.layoutManager = lm
//            binding.rvRestaurant.adapter = adapter
//        }
//    }
    private fun setupMenu(){
        adapter = RestaurantAdapter(this)
        val lm = LinearLayoutManager(requireContext())
        binding.rvRestaurant.layoutManager = lm
        binding.rvRestaurant.adapter = adapter

        binding.linearView.setOnClickListener {
            binding.linearView.setBackgroundResource(R.drawable.bg_switch_item)
            binding.gridView.setBackgroundResource(R.drawable.bg_switch_grid)
            val lm = LinearLayoutManager(requireContext())
            binding.rvRestaurant.layoutManager = lm
            binding.rvRestaurant.adapter = adapter
        }
        binding.gridView.setOnClickListener {
            binding.linearView.setBackgroundResource(R.drawable.bg_switch_linear)
            binding.gridView.setBackgroundResource(R.drawable.bg_switch_item)
            val lm = GridLayoutManager(requireContext(), 2)
            binding.rvRestaurant.layoutManager = lm
            binding.rvRestaurant.adapter = adapter
        }

}

    override fun onItemClick(position: Int) {
        val builder = AlertDialog.Builder(requireContext())
        val dialogLayout =layoutInflater.inflate(R.layout.item_view_restaurant_clicked,null)
        val tvName = dialogLayout.findViewById<TextView>(R.id.txtRestaurantName)
        val tvAddress = dialogLayout.findViewById<TextView>(R.id.txtRestaurantAddr)
        val ivImage = dialogLayout.findViewById<ImageView>(R.id.imgRestaurant)
        tvName.text = DataStore.getDataSet()[position].Name
        tvAddress.text = DataStore.getDataSet()[position].Address
        Glide.with(dialogLayout).load(DataStore.getDataSet()[position].image).into(ivImage)
        with(builder){
            setTitle("Remove item")
            setMessage("Do you want to remove this item?")
            setPositiveButton("Delete"){dialog, which ->
                val restaurant : ArrayList<Restaurant>  = DataStore.getDataSet()
                restaurant.removeAt(position)
                adapter.submitList(restaurant)
                adapter.notifyItemRemoved(position)
                Toast.makeText(requireContext(),"Xoa item thanh cong", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            setNegativeButton("Cancel"){dialog, which ->
                dialog.dismiss()
            }
            setView(dialogLayout)
            show()
        }
    }

}
