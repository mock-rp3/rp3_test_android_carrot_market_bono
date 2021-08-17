package com.example.carrotmarket.src.users.models

import com.google.gson.annotations.SerializedName

data class ResultSignUp (

    @SerializedName("jwt") val jwt: String,
    @SerializedName("userInfoIdx") val userInfoIdx: Int

)