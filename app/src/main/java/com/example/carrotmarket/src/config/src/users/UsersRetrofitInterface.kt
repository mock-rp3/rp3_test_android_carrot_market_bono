package com.example.carrotmarket.src.users

import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.src.config.src.users.models.MyPageResponse
import com.example.carrotmarket.src.users.models.PostSignUpRequest
import com.example.carrotmarket.src.users.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface UsersRetrofitInterface {

    @POST("/app/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>


    @GET("/app/users/{userInfoIdx}")
    fun getMyPage(
        @Header("x-access-token") X_ACCESS_TOKEN:String,
        @Path("userInfoIdx") userInfoIdx:Int
    ) : Call<MyPageResponse>


}