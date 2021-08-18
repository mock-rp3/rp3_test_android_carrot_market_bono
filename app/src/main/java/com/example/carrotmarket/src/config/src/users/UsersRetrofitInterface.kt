package com.example.carrotmarket.src.users

import com.example.carrotmarket.src.config.src.users.models.MyPageResponse
import com.example.carrotmarket.src.login.models.LoginResponse
import com.example.carrotmarket.src.login.models.PostLoginRequest
import com.example.carrotmarket.src.users.models.PostSignUpRequest
import com.example.carrotmarket.src.users.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UsersRetrofitInterface {

    @POST("/app/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>


    @GET("/app/users")
    fun getMyPage(
        @Query("userInfoIdx") userInfoIdx:Int
    ) : Call<MyPageResponse>


}