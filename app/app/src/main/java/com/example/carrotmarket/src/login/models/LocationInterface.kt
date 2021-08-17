package com.example.carrotmarket.src.login.models

import retrofit2.http.GET
import retrofit2.http.Query

interface LocationInterface {

    @GET("")
    fun getLocation(
        @Query("confmKey") confmKey: String,
        @Query("currentPage") currentPage: Int,
        @Query("countPerPage") countPerPage: Int,
        @Query("keyword") keyword: String,
    )
}