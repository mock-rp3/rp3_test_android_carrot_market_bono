package com.example.carrotmarket.src.config.src.main.btm.products.product.search.user

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.SearchUserItemBinding
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.user.models.UserResult

class UserAdapter(private val context: Context, private var userArrayList:ArrayList<UserResult>):
    RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    var userDataList: ArrayList<UserResult> = userArrayList


    class ViewHolder(val binding: SearchUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: UserResult) {
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): UserAdapter.ViewHolder {

        var binding = SearchUserItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {


        holder.binding.userImgProfile.background = context.resources.getDrawable(R.drawable.image_rounding_oval)
        holder.binding.userImgProfile.clipToOutline = true

        Glide.with(context)
            .load(userDataList[position].profileImageUrl)
            .into(holder.binding.userImgProfile)
        holder.binding.userTxtName.text= userDataList[position].nickname
    }

    override fun getItemCount(): Int =userDataList.size


}