package com.example.carrotmarket.src.config.src.main.btm.home.models

import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.login.models.ResultLogin
import com.google.gson.annotations.SerializedName



data class ResponseHome(

    @SerializedName("result") val result: ArrayList<ResultHome>
) : BaseResponse()