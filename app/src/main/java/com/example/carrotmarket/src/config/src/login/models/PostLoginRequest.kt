package com.example.carrotmarket.src.login.models

import com.google.gson.annotations.SerializedName

data class PostLoginRequest(
    @SerializedName("userID") val userID: String,
    @SerializedName("password") val password: String,

    )