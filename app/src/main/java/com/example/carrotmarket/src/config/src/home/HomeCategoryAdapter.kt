package com.example.carrotmarket.src.config.src.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.HomeCategoryItemBinding
import com.example.carrotmarket.src.config.src.home.models.HomeCategoryData
import com.example.carrotmarket.src.home.Product

class HomeCategoryAdapter(private val context: Context, private var homeCategoryArrayList:ArrayList<HomeCategoryData>):
RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder>(){

    var homeCategoryDataList: ArrayList<HomeCategoryData> = homeCategoryArrayList


    class ViewHolder(val binding: HomeCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeCategoryData) {
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HomeCategoryAdapter.ViewHolder {

        var binding = HomeCategoryItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeCategoryAdapter.ViewHolder, position: Int) {

        holder.binding.homeCategoryItemImg.setImageResource(homeCategoryDataList[position].category_img)
        holder.binding.homeCategoryItemTxt.text=homeCategoryDataList[position].category_name
    }

    override fun getItemCount(): Int =homeCategoryDataList.size


}