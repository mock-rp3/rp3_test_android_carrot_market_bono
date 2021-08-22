package com.example.carrotmarket.src.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.databinding.HomeItemBinding
import com.example.carrotmarket.src.config.src.main.btm.home.models.ResultHome
import com.example.carrotmarket.src.config.src.main.btm.home.product.detail.ProductDetailActivity
import java.text.DecimalFormat


class HomeAdapter(
    private val context: Context,
    private var responseHome: ArrayList<ResultHome>
//    private var productArrayList: ArrayList<Product>,
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

//    var productDataList: ArrayList<Product> = productArrayList

    var productDataList: ArrayList<ResultHome> = responseHome

//    var dataSet:ArrayList<ResultHome> = arrayListOf()


    class ViewHolder(val binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResultHome) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = HomeItemBinding.inflate(
            LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context)
            .load(productDataList[position].imageUrl)
            .into(holder.binding.homeItemImage)
        holder.binding.homeItemName.text=productDataList[position].title
        holder.binding.homeItemLocation.text=productDataList[position].regionNameTown
        holder.binding.homeItemTime.text=productDataList[position].pulledAt
//        holder.binding.homeItemPrice.text = productDataList[position].price.toString()

        val decimalFormat = DecimalFormat("###,###")
        val priceDecimalFormat =decimalFormat.format(productDataList[position].price)
        holder.binding.homeItemPrice.text = "$priceDecimalFormat 원"
        holder.binding.homeItemImage.background = context.resources.getDrawable(R.drawable.image_rounding)
        holder.binding.homeItemImage.clipToOutline = true



//        holder.binding.homeItemPrice.setText(productDataList[position].price)

//        holder.binding.homeItemPrice.setText(String.(productDataList[position].price))
        holder.binding.homeItemCl.setOnClickListener {
            var intent = Intent(context, ProductDetailActivity::class.java )
            intent.putExtra("productIdx",productDataList[position].productIdx)
            context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return productDataList.size
    }

}