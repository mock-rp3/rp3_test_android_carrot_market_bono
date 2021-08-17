package com.example.carrotmarket.src.users

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.login.models.LoginResponse
import com.example.carrotmarket.src.login.models.PostLoginRequest
import com.example.carrotmarket.src.users.models.PostSignUpRequest
import com.example.carrotmarket.src.users.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersService(val view: UsersActivityView) {


    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest) {
        val signUpRetrofitInterface =
            ApplicationClass.sRetrofit.create(UsersRetrofitInterface::class.java)
        signUpRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object :
            Callback<SignUpResponse> {
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                view.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?:"통신오류")
            }
        })
    }


}