package com.example.carrotmarket.src.config.src.users

import android.util.Log
import com.bumptech.glide.Glide
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.users.models.MyPageResponse
import com.example.carrotmarket.src.users.UsersRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService(val view: MyPageFragmentView) {


    fun tryGetMyPage(userInfoIdx: Int){
        val myPageRetrofitInterface =
            ApplicationClass.sRetrofit.create(UsersRetrofitInterface::class.java)
        myPageRetrofitInterface.getMyPage(userInfoIdx).enqueue(object:
            Callback<MyPageResponse> {
            override fun onResponse(
                call: Call<MyPageResponse>,
                response: Response<MyPageResponse>
            ) {

                view.onGetMyPageSuccess(response.body() as MyPageResponse)


//                userInfoIdx


//                val userInfoIdx = result.result.userInfoIdx

            //                result.nickname.toString()

            }

            override fun onFailure(call: Call<MyPageResponse>, t: Throwable) {

                view.onGetMyPageFailure(t.message ?:"통신오류")
            }
        }
        )


    }
}