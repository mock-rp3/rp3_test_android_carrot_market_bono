package com.example.carrotmarket.src.config.src.product

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ProductDetailItemSliderBinding

class ProductDetailImageSliderAdapter(
    private val context: Context,
    private val sliderImage: Array<String>,
) :
    RecyclerView.Adapter<ProductDetailImageSliderAdapter.MyViewHolder>() {
    class MyViewHolder(var binding: ProductDetailItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProductDetailImageSliderAdapter.MyViewHolder {
        val binding = ProductDetailItemSliderBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductDetailImageSliderAdapter.MyViewHolder,
        position: Int,
    ) {

    }

    override fun getItemCount(): Int {
        return sliderImage.size
    }


}