package com.example.carrotmarket.src.login.models

import com.google.gson.annotations.SerializedName

data class ResultLogin (

    @SerializedName("userInfoIdx") val userInfoIdx: Int,
    @SerializedName("authJwt") val authJwt: String
        )