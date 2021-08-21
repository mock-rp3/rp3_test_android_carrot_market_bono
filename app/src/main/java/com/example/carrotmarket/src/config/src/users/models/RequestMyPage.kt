package com.example.carrotmarket.src.config.src.users.models

import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.google.gson.annotations.SerializedName
import retrofit2.http.Header


data class RequestMyPage (

    @SerializedName("userInfoIdx") val userInfoIdx: Int,
    @Header("x-access-token") val X_ACCESS_TOKEN:String

    )