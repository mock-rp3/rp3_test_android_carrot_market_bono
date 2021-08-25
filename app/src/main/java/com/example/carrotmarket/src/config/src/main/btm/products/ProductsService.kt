package com.example.carrotmarket.src.config.src.main.btm.products

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResponseHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsService(val view: HomeFragmentView) {
    fun tryGetHome() {
        val homeRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
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