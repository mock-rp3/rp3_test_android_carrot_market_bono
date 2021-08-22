package com.example.carrotmarket.src.config.src.main.btm.home.product.detail.models

import com.google.gson.annotations.SerializedName

data class ResultDetail(
    @SerializedName("canProposal") val priceProposal: String,
//    val createdAt: String,
    @SerializedName("description") val contents: String,
    val mannerGrade: Int,
    @SerializedName("name") val cate: String,
    val nickname: String,
    val price: Int,
    val imageUrl: String,
    val productIdx: Int,
    val profileImageUrl: String,
    val pulledAt: String,
//    val regionNameGu: String,
    val regionNameTown: String,
    val title: String,
//    val userInfoIdx: Int,
//    val wishCount: Int
)

//data class Image(
//    val imageUrl: String,
//
//    )