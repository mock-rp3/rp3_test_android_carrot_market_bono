package com.example.carrotmarket.src.config.src.main.btm.home.product.detail.models

import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.config.src.main.btm.home.models.ResultHome
import com.google.gson.annotations.SerializedName



data class ResponseDetail(
    @SerializedName("result") val result: ArrayList<ArrayList<ResultDetail>>
) : BaseResponse()