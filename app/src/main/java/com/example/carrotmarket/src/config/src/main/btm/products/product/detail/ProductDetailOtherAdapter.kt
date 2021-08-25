package com.example.carrotmarket.src.config.src.main.btm.products.product.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.ProductDetailItemBinding
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResultSellerProduct
import java.text.DecimalFormat

class ProductDetailOtherAdapter(
    private val context: Context,
    private var otherArrayList: ArrayList<ResultSellerProduct>,
) : RecyclerView.Adapter<ProductDetailOtherAdapter.ViewHolder>() {
    class ViewHolder(val binding: ProductDetailItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding = ProductDetailItemBinding.inflate(
            LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.productDetailItemName.text = otherArrayList[position].title

        val decimalFormat = DecimalFormat("###,###")
        val priceDecimalFormat = decimalFormat.format(otherArrayList[position].price)
        holder.binding.productDetailItemPrice.text = "$priceDecimalFormat 원"

        holder.binding.productDetailItemImg.background =
            context.resources.getDrawable(R.drawable.image_rounding)
        holder.binding.productDetailItemImg.clipToOutline = true
        Glide.with(context)
            .load(otherArrayList[position].imageUrl)
            .into(holder.binding.productDetailItemImg)


    }

    override fun getItemCount(): Int {
        return otherArrayList.size
    }


}