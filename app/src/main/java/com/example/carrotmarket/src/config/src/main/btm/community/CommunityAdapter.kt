package com.example.carrotmarket.src.config.src.main.btm.community

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.HomeItemBinding
import com.example.carrotmarket.databinding.LifeItemBinding
import com.example.carrotmarket.src.config.src.main.btm.community.models.CommunityResult
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResultHome
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.ProductDetailActivity
import java.text.DecimalFormat

class CommunityAdapter(
    private val context: Context,
    private var communityResponse: ArrayList<CommunityResult>
) :
    RecyclerView.Adapter<CommunityAdapter.ViewHolder>() {

    class ViewHolder(val binding: LifeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CommunityResult) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = LifeItemBinding.inflate(
            LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.lifeCate.text=communityResponse[position].name

        holder.binding.lifeContents.text = communityResponse[position].description

//        holder.binding.lifeNick.text=communityResponse[position].
        holder.binding.lifeLocal.text=communityResponse[position].regionNameTown
        holder.binding.lifeTime.text=communityResponse[position].createdAt

        holder.binding.comment.text="댓글 "+communityResponse[position].commentCount.toString()

        if(communityResponse[position].commentCount==0){
            holder.binding.comment.text="댓글쓰기"
        }


    }


    override fun getItemCount(): Int {
        return communityResponse.size
    }

}