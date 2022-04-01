package com.example.food_delivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food_delivery.model.Restaurant

class RestaurantAdapter(val mListener : OnItemClickListener) : ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(RestaurantDiffUtil()) {


    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    class RestaurantDiffUtil : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder.from(parent,mListener)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {

        val restaurant = getItem(position)
        holder.bindData(restaurant)
    }


    class RestaurantViewHolder(itemView: View,listener : OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        companion object {
            fun from(parent: ViewGroup,listener : OnItemClickListener): RestaurantViewHolder {
                var layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_view_restaurant, parent, false)
                return RestaurantViewHolder(view,listener)
            }
        }
        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
        fun bindData(restaurant : Restaurant){
            val tvName = itemView.findViewById<TextView>(R.id.txtRestaurantName)
            val tvAddress = itemView.findViewById<TextView>(R.id.txtRestaurantAddr)
            val ivImage = itemView.findViewById<ImageView>(R.id.imgRestaurant)

            // bind data
            tvName.text = restaurant.name
            tvAddress.text = restaurant.address
            Glide.with(itemView).load(restaurant.image).into(ivImage)
        }

    }

}