package com.example.carrotmarket.src.config.src.main.btm.products.category

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.HomeCategoryItemBinding
import com.example.carrotmarket.src.config.src.main.btm.products.category.models.HomeCategoryData
import com.example.carrotmarket.src.config.src.main.btm.products.category.select.CategorySelectActivity

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
    ): ViewHolder {

        var binding = HomeCategoryItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.homeCategoryItemImg.setImageResource(homeCategoryDataList[position].category_img)
        holder.binding.homeCategoryItemTxt.text=homeCategoryDataList[position].category_name

        holder.binding.homeCategoryItemLl.setOnClickListener {
            var intent = Intent(context, CategorySelectActivity::class.java)
            intent.putExtra("categoryName", homeCategoryDataList[position].category_name)
            var category:Int = position+1
            intent.putExtra("category",category)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int =homeCategoryDataList.size


}