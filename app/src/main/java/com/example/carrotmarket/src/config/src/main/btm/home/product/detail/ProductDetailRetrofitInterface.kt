package com.example.carrotmarket.src.config.src.main.btm.home.product.detail

import com.example.carrotmarket.src.config.src.main.btm.home.models.ResponseHome
import com.example.carrotmarket.src.config.src.main.btm.home.product.detail.models.ResponseDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDetailRetrofitInterface {

    @GET("/app/products/{productIdx}")
    fun getProductDetail(
            @Path("productIdx") productIdx:Int
    ): Call<ResponseDetail>

}