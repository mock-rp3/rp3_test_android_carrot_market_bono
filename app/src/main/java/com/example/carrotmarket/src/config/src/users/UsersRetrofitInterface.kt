package com.example.carrotmarket.src.users

import com.example.carrotmarket.src.config.src.users.mypage.models.MyPageResponse
import com.example.carrotmarket.src.config.src.users.profile.models.RequestProfile
import com.example.carrotmarket.src.config.src.users.profile.models.ResponseProfile
import com.example.carrotmarket.src.config.src.users.signup.models.PostSignUpRequest
import com.example.carrotmarket.src.config.src.users.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface UsersRetrofitInterface {

//    @POST("/app/users")
//    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>

    @POST("/app/join-login")
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