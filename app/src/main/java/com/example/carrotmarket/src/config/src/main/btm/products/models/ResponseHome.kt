package com.example.carrotmarket.src.config.src.main.btm.products.models

import com.example.carrotmarket.config.BaseResponse
import com.google.gson.annotations.SerializedName



data class ResponseHome(

    @SerializedName("result") val result: ArrayList<ResultHome>
) : BaseResponse()