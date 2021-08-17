package com.example.carrotmarket.src.login

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.login.models.LoginResponse
import com.example.carrotmarket.src.login.models.PostLoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginActivityView) {



    fun tryPostLogin(postLoginRequest: PostLoginRequest){
        val LoginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        LoginRetrofitInterface.postLogin(postLoginRequest).enqueue(object  :
        Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view.onPostLoginSuccess(response.body() as LoginResponse)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.onPostLoginFailure(t.message ?:"통신오류")
            }
        })
    }

}