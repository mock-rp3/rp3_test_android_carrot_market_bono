package com.example.carrotmarket.src.login.models

import com.google.gson.annotations.SerializedName

data class ResultLogin (

    @SerializedName("authJwt") val authJwt: String,
    @SerializedName("userInfoIdx") val userInfoIdx: Int
        )