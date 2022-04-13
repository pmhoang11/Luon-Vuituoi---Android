package com.example.food_delivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_delivery.model.Restaurant
import android.text.TextUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide



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
                val view = layoutInflater.inflate(R.layout.item_restaurant, parent, false)
                return RestaurantViewHolder(view,listener)
            }
        }
        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
        fun bindData(restaurant : Restaurant){
            val tvName = itemView.findViewById<TextView>(R.id.name)
            val tvAddress = itemView.findViewById<TextView>(R.id.address)
            val ivImage = itemView.findViewById<ImageView>(R.id.picturePath)
            // bind data
            tvName.text = restaurant.Name
            tvAddress.text = restaurant.Address
            tvAddress.ellipsize = TextUtils.TruncateAt.MARQUEE
            tvAddress.isSelected = true
            tvName.ellipsize = TextUtils.TruncateAt.MARQUEE
            tvName.isSelected = true
            Glide.with(itemView).load(restaurant.image).into(ivImage)
        }

    }

}

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
//        return RestaurantViewHolder.from(parent)
//    }
//
//    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
//        val restaurant = dataSet[position]
//        holder.bindData(restaurant)
//    }
//
//    override fun getItemCount(): Int {
//        return dataSet.size
//    }
//
//    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        companion object {
//            fun from(parent: ViewGroup) : RestaurantViewHolder {
//                var layoutInflater = LayoutInflater.from(parent.context)
//                var view = layoutInflater.inflate(R.layout.item_restaurant, parent, false)
//                return RestaurantViewHolder(view)
//            }
//        }
//
//        fun bindData(restaurant: Restaurant) {
//            val tvName = itemView.findViewById<TextView>(R.id.name)
//            val tvAddress = itemView.findViewById<TextView>(R.id.address)
//            val ivPic = itemView.findViewById<ImageView>(R.id.picturePath)
//
//            tvName.text = restaurant.Name
//            tvAddress.text = restaurant.Address
//            ivPic.setImageResource(restaurant.MobilePicturePath)
//        }
//
//    }
//}