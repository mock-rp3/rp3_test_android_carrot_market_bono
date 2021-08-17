package com.example.carrotmarket.src.login

import com.example.carrotmarket.src.login.models.LoginResponse
import com.example.carrotmarket.src.login.models.PostLoginRequest
import com.example.carrotmarket.src.users.models.PostSignUpRequest
import com.example.carrotmarket.src.users.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {

    @POST("/app/logIn")
    fun postLogin(@Body params: PostLoginRequest): Call<LoginResponse>
}