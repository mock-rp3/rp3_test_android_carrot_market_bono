package com.example.carrotmarket.src.config.src.main.btm.home

import com.example.carrotmarket.src.config.src.main.btm.home.models.ResponseHome
import retrofit2.Call
import retrofit2.http.GET

interface HomeRetrofitInterface {


    @GET("/app/products")
    fun getProduct(): Call<ResponseHome>
}