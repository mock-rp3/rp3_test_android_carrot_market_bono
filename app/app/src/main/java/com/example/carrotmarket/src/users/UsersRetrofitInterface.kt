package com.example.carrotmarket.src.users

import com.example.carrotmarket.src.login.models.LoginResponse
import com.example.carrotmarket.src.login.models.PostLoginRequest
import com.example.carrotmarket.src.users.models.PostSignUpRequest
import com.example.carrotmarket.src.users.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsersRetrofitInterface {

    @POST("/app/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>

}