package com.example.carrotmarket.src.config.src.users.signup

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.users.UsersRetrofitInterface
import com.example.carrotmarket.src.config.src.users.signup.models.PostSignUpRequest
import com.example.carrotmarket.src.config.src.users.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpService(val view: SignUpActivityView) {


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