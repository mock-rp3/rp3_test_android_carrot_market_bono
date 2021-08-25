package com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResponseHome
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IngService(val view: IngView) {

    fun tryGetIng(X_ACCESS_TOKEN:String, status:String, sellerId:Int) {
        val ingRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        ingRetrofitInterface.getIng(X_ACCESS_TOKEN,status,sellerId).enqueue(object :
            Callback<IngResponse> {
            override fun onResponse(
                call: Call<IngResponse>,
                response: Response<IngResponse>,
            ) {
                view.onGetIngSuccess(response.body() as IngResponse)

            }

            override fun onFailure(call: Call<IngResponse>, t: Throwable) {
                view.onGetIngFailure(t.message ?: "통신오류")
            }

        }
        )
    }
}