package com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models

import com.google.gson.annotations.SerializedName

data class RequestPostWriting (


    val title:String,
    @SerializedName("description") val contents: String,
    val price:Int,
    val canProposal:String,
    val categoryId:Int,
    val sellerId:Int,
    val imageUrl:String

        )