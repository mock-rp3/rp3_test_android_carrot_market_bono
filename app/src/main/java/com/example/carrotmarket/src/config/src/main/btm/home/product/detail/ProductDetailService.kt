package com.example.carrotmarket.src.config.src.main.btm.home.product.detail

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.home.HomeRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.home.models.ResponseHome
import com.example.carrotmarket.src.config.src.main.btm.home.product.detail.models.ResponseDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailService(val view: ProductDetailActivityView) {

    fun tryGetProductDetail(productIdx:Int) {
        val productDetailRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductDetailRetrofitInterface::class.java)
        productDetailRetrofitInterface.getProductDetail(productIdx).enqueue(object :
            Callback<ResponseDetail> {
            override fun onResponse(
                call: Call<ResponseDetail>,
                response: Response<ResponseDetail>,
            ) {
                view.onGetProductDetailSuccess(response.body() as ResponseDetail)

            }

            override fun onFailure(call: Call<ResponseDetail>, t: Throwable) {
                view.onGetProductDetailFailure(t.message ?: "통신오류")
            }

        }
        )
    }

}