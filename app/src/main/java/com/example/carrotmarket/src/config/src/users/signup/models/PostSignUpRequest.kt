package com.example.carrotmarket.src.config.src.users.signup.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest (

    val regionNameCity:String,
    val regionNameGu:String,
    val regionNameTown:String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("password") val password: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("profileImageUrl") var profileImageUrl: String,

    )