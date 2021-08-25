package com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models

import com.example.carrotmarket.config.BaseResponse
import com.google.gson.annotations.SerializedName



data class ResponseDetail(
    @SerializedName("result") val result: ArrayList<ArrayList<ResultDetail>>
) : BaseResponse()