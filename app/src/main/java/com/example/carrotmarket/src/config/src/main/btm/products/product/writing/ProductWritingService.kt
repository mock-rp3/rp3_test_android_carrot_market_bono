package com.example.carrotmarket.src.config.src.main.btm.products.product.writing

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.RequestPostWriting
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.ResponseWriting
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductWritingService(val view: ProductWritingActivityView) {

    fun tryPostProductWriting(requestPostWriting: RequestPostWriting) {
        val proRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
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