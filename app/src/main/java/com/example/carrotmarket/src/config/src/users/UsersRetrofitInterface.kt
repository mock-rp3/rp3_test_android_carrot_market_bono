package com.example.carrotmarket.src.users

import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.src.config.src.users.models.MyPageResponse
import com.example.carrotmarket.src.config.src.users.profile.models.RequestProfile
import com.example.carrotmarket.src.config.src.users.profile.models.ResponseProfile
import com.example.carrotmarket.src.users.models.PostSignUpRequest
import com.example.carrotmarket.src.users.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface UsersRetrofitInterface {

    @POST("/app/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>


    @GET("/app/users/{userInfoIdx}")
    fun getMyPage(
        @Header("x-access-token") X_ACCESS_TOKEN: String,
        @Path("userInfoIdx") userInfoIdx: Int,
    ): Call<MyPageResponse>

//
//    @PATCH("/app/users/{userInfoIdx}")
//    fun patchProfile(@Body params: RequestProfile) : Call<ResponseProfile>
//    fun jwtIdx(@Header("x-access-token") X_ACCESS_TOKEN: String,
//               @Path("userInfoIdx") userInfoIdx: Int): Call<ResponseProfile>


    @PATCH("/app/users/{userInfoIdx}")
    fun patchProfile(
        @Body params: RequestProfile,
        @Header("x-access-token") X_ACCESS_TOKEN: String,
        @Path("userInfoIdx") userInfoIdx: Int,
    ): Call<ResponseProfile>


}