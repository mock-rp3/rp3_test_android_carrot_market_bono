package com.example.carrotmarket.src.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.databinding.HomeItemBinding
import com.example.carrotmarket.src.config.src.product.ProductDetailActivity


class HomeAdapter(
    private val context: Context,
    private var productArrayList: ArrayList<Product>,
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var productDataList: ArrayList<Product> = productArrayList

    class ViewHolder(val binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Product) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = HomeItemBinding.inflate(
            LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.homeItemImage.setImageResource(productDataList[position].item_img)
        holder.binding.homeItemName.text=productDataList[position].item_name
        holder.binding.homeItemLocation.text=productDataList[position].item_location
        holder.binding.homeItemTime.text=productDataList[position].item_time
        holder.binding.homeItemPrice.text=productDataList[position].item_price

        holder.binding.homeItemCl.setOnClickListener {

            var intent = Intent(context, ProductDetailActivity::class.java )
            context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return productDataList.size
    }

}