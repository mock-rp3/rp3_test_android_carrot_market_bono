package com.example.carrotmarket.src.config.src.main.btm.home.product.writing

import com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models.RequestPostWriting
import com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models.ResponseWriting
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ProductWritingRetrofitInterface {


    @POST("/app/products")
    fun postProductWriting(@Body params: RequestPostWriting): Call<ResponseWriting>
}