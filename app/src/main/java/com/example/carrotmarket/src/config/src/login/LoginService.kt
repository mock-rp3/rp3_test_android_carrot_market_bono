package com.example.carrotmarket.src.login

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.login.models.ResponseLogin
import com.example.carrotmarket.src.login.models.PostLoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginActivityView) {



    fun tryPostLogin(postLoginRequest: PostLoginRequest){
        val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginRetrofitInterface.postLogin(postLoginRequest).enqueue(object  :
        Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                val result = response.body() as ResponseLogin
                 view.onPostLoginSuccess(result)

//                ApplicationClass.sSharedPreferences.getString("jwt", result.result.authJwt)
//                ApplicationClass.editor.putString("jwt",result.result.authJwt)
//                ApplicationClass.editor.commit()

            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                view.onPostLoginFailure(t.message ?:"통신오류")
            }
        })
    }

}