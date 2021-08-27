package com.example.carrotmarket.src.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.LoginLocationListItemBinding
import com.example.carrotmarket.src.config.src.users.signup.SignUpMainActivity


class LoginLocationAdapter(
    private val context: Context,
    private var locationArrayList: ArrayList<Location>,
) :
    RecyclerView.Adapter<LoginLocationAdapter.ViewHolder>() {


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


        holder.binding.aroundSub.setOnClickListener {
            var intent = Intent(context, SignUpMainActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }

    }


    override fun getItemCount(): Int {
        return locationDataList.size
    }

}