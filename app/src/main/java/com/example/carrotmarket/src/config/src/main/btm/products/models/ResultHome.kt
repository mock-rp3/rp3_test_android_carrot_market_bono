package com.example.carrotmarket.src.config.src.main.btm.products.models

import com.google.gson.annotations.SerializedName


data class ResultHome (

    @SerializedName("productIdx") val productIdx: Int,
    @SerializedName("imageUrl") val imageUrl: String,
//    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("title") val title: String,
    @SerializedName("regionNameTown") val regionNameTown: String,

    @SerializedName("pulledAt") val pulledAt: String,
//    @SerializedName("regionNameGu") val regionNameGu: String,
    @SerializedName("price") val price: Int,

    @SerializedName("wishCount") val wishCount: Int

)