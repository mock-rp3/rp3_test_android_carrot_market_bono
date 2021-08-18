package com.example.carrotmarket.src.config.src.users.models

import com.google.gson.annotations.SerializedName

data class ResultMyPage (
    @SerializedName("nickname") val nickname: String,
    @SerializedName("profileImageUrl") val profileImageUrl: String



)