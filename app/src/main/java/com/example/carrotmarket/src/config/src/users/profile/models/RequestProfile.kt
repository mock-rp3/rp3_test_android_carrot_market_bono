package com.example.carrotmarket.src.config.src.users.profile.models

import com.google.gson.annotations.SerializedName
import retrofit2.http.Header


data class RequestProfile (

//    @Header("x-access-token") val X_ACCESS_TOKEN:String,
//    @SerializedName("userInfoIdx") val userInfoIdx: Int,
    val nickname: String,
    val profileImageUrl:String,

    )