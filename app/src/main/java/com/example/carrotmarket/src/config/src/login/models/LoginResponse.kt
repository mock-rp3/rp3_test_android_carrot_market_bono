package com.example.carrotmarket.src.login.models

import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.users.models.ResultSignUp
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    // 베이스 리스폰스를 상속 받았으므로, 아래 내용은 포함이 되었습니다.
    // @SerializedName("isSuccess") val isSuccess: Boolean,
    // @SerializedName("code") val code: Int,
    // @SerializedName("message") val message: String,
    @SerializedName("result") val result: ResultSignUp
) : BaseResponse()