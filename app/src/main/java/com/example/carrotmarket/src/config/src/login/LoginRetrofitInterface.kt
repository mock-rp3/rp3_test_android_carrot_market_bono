package com.example.carrotmarket.src.login

import com.example.carrotmarket.src.login.models.ResponseLogin
import com.example.carrotmarket.src.login.models.PostLoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginRetrofitInterface {

    @POST("/app/logIn")
    fun postLogin(@Body params: PostLoginRequest): Call<ResponseLogin>
}