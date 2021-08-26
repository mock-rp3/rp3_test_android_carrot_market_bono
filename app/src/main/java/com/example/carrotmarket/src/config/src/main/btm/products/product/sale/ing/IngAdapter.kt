package com.example.carrotmarket.src.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.databinding.HomeItemBinding
import com.example.carrotmarket.databinding.SaleItemBinding
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResultHome
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.ProductDetailActivity
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ProductSaleListActivity
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.AdapterService
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.AdapterView
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.IngService
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.ProductSaleListIngFragment
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResult
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.models.StatusRequest
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.user.ProductSearchUserFragment
import java.text.DecimalFormat


class IngAdapter(
    private val context: Context,
    private var responseHome: ArrayList<IngResult>
) :
    RecyclerView.Adapter<IngAdapter.ViewHolder>() {

    var productDataList: ArrayList<IngResult> = responseHome


    class ViewHolder(val binding: SaleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: IngResult) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = SaleItemBinding.inflate(
            LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context)
            .load(productDataList[position].imageUrl)
            .into(holder.binding.saleImg)
        holder.binding.saleName.text=productDataList[position].title
        holder.binding.saleLocation.text=productDataList[position].regionNameTown
        holder.binding.saleTime.text=productDataList[position].updatedAt
//        holder.binding.homeItemPrice.text = productDataList[position].price.toString()

        val decimalFormat = DecimalFormat("###,###")
        val priceDecimalFormat =decimalFormat.format(productDataList[position].price)
        holder.binding.salePrice.text = "$priceDecimalFormat 원"
        holder.binding.saleImg.background = context.resources.getDrawable(R.drawable.image_rounding)
        holder.binding.saleImg.clipToOutline = true


//        holder.binding.productSaleListChangeIng.setOnClickListener {
//            productDataList[position].status="reserved"
//
//        }
//
//        holder.binding.productSaleListChangeComp.setOnClickListener {
//            productDataList[position].status="traded"
////traded
//        }
    }


    override fun getItemCount(): Int {
        return productDataList.size
    }

}