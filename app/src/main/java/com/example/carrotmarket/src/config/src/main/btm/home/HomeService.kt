package com.example.carrotmarket.src.config.src.main.btm.home

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.home.models.ResponseHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeFragmentView) {
    fun tryGetHome() {
        val homeRetrofitInterface =
            ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getProduct().enqueue(object :
            Callback<ResponseHome> {
            override fun onResponse(
                call: Call<ResponseHome>,
                response: Response<ResponseHome>,
            ) {
                view.onGetProductSuccess(response.body() as ResponseHome)

            }

            override fun onFailure(call: Call<ResponseHome>, t: Throwable) {
                view.onGetProductFailure(t.message ?: "통신오류")
            }

        }
        )
    }
}