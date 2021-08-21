package com.example.carrotmarket.src.config.src.users

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.users.models.MyPageResponse
import com.example.carrotmarket.src.users.UsersRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

class MyPageService(val view: MyPageFragmentView) {


    fun tryGetMyPage(X_ACCESS_TOKEN:String ,userInfoIdx: Int){
        val myPageRetrofitInterface =
            ApplicationClass.sRetrofit.create(UsersRetrofitInterface::class.java)
        myPageRetrofitInterface.getMyPage(X_ACCESS_TOKEN,userInfoIdx).enqueue(object:
            Callback<MyPageResponse> {
            override fun onResponse(
                call: Call<MyPageResponse>,
                response: Response<MyPageResponse>
            ) {



                view.onGetMyPageSuccess(response.body() as MyPageResponse)


            }

            override fun onFailure(call: Call<MyPageResponse>, t: Throwable) {

                view.onGetMyPageFailure(t.message ?:"통신오류")
            }
        }
        )


    }
}