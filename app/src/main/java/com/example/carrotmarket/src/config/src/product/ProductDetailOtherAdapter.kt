package com.example.carrotmarket.src.config.src.product

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ProductDetailItemBinding

class ProductDetailOtherAdapter(private val context: Context, private var otherArrayList: ArrayList<Other>)
    : RecyclerView.Adapter<ProductDetailOtherAdapter.ViewHolder>(){
    class ViewHolder(val binding: ProductDetailItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProductDetailOtherAdapter.ViewHolder {
        val binding = ProductDetailItemBinding.inflate(
            LayoutInflater.from(context),parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductDetailOtherAdapter.ViewHolder, position: Int) {

        holder.binding.productDetailItemImg.setImageResource(otherArrayList[position].productDetailOtherImage)
        holder.binding.productDetailItemName.text=otherArrayList[position].productDetailOtherName
        holder.binding.productDetailItemPrice.text=otherArrayList[position].productDetailOtherPrice



    }

    override fun getItemCount(): Int {
        return otherArrayList.size
    }


}