package com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit.models

import com.google.gson.annotations.SerializedName



data class EditRequest (

    val title:String,
    @SerializedName("description") val contents: String,
    val price:Int,
    val canProposal:String,
    val categoryId:Int,
    val imageUrl:String

)