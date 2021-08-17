package com.example.carrotmarket.src.users.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest (


    @SerializedName("userID") val userID: String,
    @SerializedName("password") val password: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("profileImageUrl") val profileImageUrl: String,

    )