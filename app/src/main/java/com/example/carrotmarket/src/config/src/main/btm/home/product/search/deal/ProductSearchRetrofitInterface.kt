package com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal

import com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.models.ResponseSearchDeal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductSearchRetrofitInterface {

    @GET("/app/products")
    fun getSearchDeal(@Query("title")title: String) : Call<ResponseSearchDeal>
}