package com.example.carrotmarket.src.config.src.main.btm.home.product.writing

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models.RequestPostWriting
import com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models.ResponseWriting
import com.example.carrotmarket.src.login.LoginRetrofitInterface
import com.example.carrotmarket.src.login.models.PostLoginRequest
import com.example.carrotmarket.src.login.models.ResponseLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductWritingService(val view: ProductWritingActivityView) {

    fun tryPostProductWriting(requestPostWriting: RequestPostWriting) {
        val proRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductWritingRetrofitInterface::class.java)
        proRetrofitInterface.postProductWriting(requestPostWriting).enqueue(object :
            Callback<ResponseWriting> {
            override fun onResponse(
                call: Call<ResponseWriting>,
                response: Response<ResponseWriting>,
            ) {
                view.onPostProductWritingSuccess(response.body() as ResponseWriting)
            }

            override fun onFailure(call: Call<ResponseWriting>, t: Throwable) {
                view.onPostProductWritingFailure(t.message ?: "통신오류")
            }
        })
    }


}