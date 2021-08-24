package com.example.carrotmarket.src.config.src.main.btm.home.product.search.user

import com.example.carrotmarket.src.config.src.main.btm.home.product.search.user.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductSearchUserRetrofitInterface {


    @GET("/app/users")
    fun getSearchUser(@Query("name")name: String) : Call<UserResponse>
}