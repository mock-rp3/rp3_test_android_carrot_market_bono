package com.example.carrotmarket.src.login.models

import com.google.gson.annotations.SerializedName

data class PostLoginRequest(
    @SerializedName("phoneNumber") val phoneNumber: String,
    )