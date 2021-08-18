package com.example.carrotmarket.src.config.src.users.models

import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.users.models.ResultSignUp
import com.google.gson.annotations.SerializedName

data class MyPageResponse (
    @SerializedName("nickname") val nickname: String,
    @SerializedName("profileImageUrl") val profileImageUrl: String,
    @SerializedName("result") val result: ResultSignUp
) : BaseResponse()
