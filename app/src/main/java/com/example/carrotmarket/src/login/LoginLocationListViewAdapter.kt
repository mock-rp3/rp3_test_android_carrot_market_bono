package com.example.carrotmarket.src.login

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.LoginLocationListItemBinding

class LoginLocationListViewAdapter(
    private val context: Context,
    private var locationArrayList: ArrayList<Location>,
) :
    RecyclerView.Adapter<LoginLocationListViewAdapter.ViewHolder>() {


    var locationDataList: ArrayList<Location> = locationArrayList

    class ViewHolder(val binding: LoginLocationListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Location) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = LoginLocationListItemBinding.inflate(
            LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.aroundSub.text = locationDataList[position].location
    }


    override fun getItemCount(): Int {
        return locationDataList.size
    }

}