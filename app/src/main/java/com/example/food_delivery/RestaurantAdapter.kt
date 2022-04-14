package com.example.food_delivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_delivery.model.Restaurant


class RestaurantAdapter(var dataSet: List<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = dataSet[position]
        holder.bindData(restaurant)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {
            fun from(parent: ViewGroup) : RestaurantViewHolder {
                var layoutInflater = LayoutInflater.from(parent.context)
                var view = layoutInflater.inflate(R.layout.item_restaurant, parent, false)
                return RestaurantViewHolder(view)
            }
        }

        fun bindData(restaurant: Restaurant) {
            val tvName = itemView.findViewById<TextView>(R.id.name)
            val tvAddress = itemView.findViewById<TextView>(R.id.address)
            val ivPic = itemView.findViewById<ImageView>(R.id.picturePath)

            tvName.text = restaurant.Name
            tvAddress.text = restaurant.Address
            ivPic.setImageResource(restaurant.MobilePicturePath)
        }

    }
}