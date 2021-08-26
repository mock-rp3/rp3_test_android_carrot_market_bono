package com.example.carrotmarket.src.config.src.main.btm.products.product.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.databinding.ProductDetailItemSliderBinding
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResultDetail
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResultSellerProduct

class ProductDetailImageSliderAdapter(
    private val context: Context,
    private val sliderImage: ArrayList<ResultDetail>,
) :
    RecyclerView.Adapter<ProductDetailImageSliderAdapter.MyViewHolder>() {
    class MyViewHolder(var binding: ProductDetailItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyViewHolder {
        val binding = ProductDetailItemSliderBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int,
    ) {
//        for (i in 0..1) {
            Glide.with(context)
                .load(sliderImage[position].imageUrl)
                .into(holder.binding.sliderImg)
//        }
    }

    override fun getItemCount(): Int {
        return sliderImage.size
    }


}