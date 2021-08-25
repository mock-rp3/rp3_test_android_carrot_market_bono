package com.example.carrotmarket.src.config.src.users.signup.models

import com.google.gson.annotations.SerializedName

data class ResultSignUp (

    @SerializedName("jwt") val jwt: String,
    @SerializedName("userInfoIdx") val userInfoIdx: Int

)