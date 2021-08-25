package com.example.carrotmarket.src.config.src.users.mypage.models

import com.example.carrotmarket.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class MyPageResponse (

    @SerializedName("result") val result: ResultMyPage
) : BaseResponse()
