package com.example.carrotmarket.src.config.src.users.models

import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.users.models.ResultSignUp
import com.google.gson.annotations.SerializedName
import retrofit2.http.Header

data class MyPageResponse (

    @SerializedName("result") val result: ResultMyPage
) : BaseResponse()
