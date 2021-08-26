package com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSearchDeal
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductSearchDealService(val view: ProductSearchDealView) {

    fun tryGetDealSearch(title: String){
        val productSearchRetrofitInterface = ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        productSearchRetrofitInterface.getSearchDeal(title).enqueue(object  : Callback<ResponseSearchDeal>{
            override fun onResponse(
                call: Call<ResponseSearchDeal>,
                response: Response<ResponseSearchDeal>
            ) {

                view.onGetDealSearchSuccess(response.body() as ResponseSearchDeal)
            }

            override fun onFailure(call: Call<ResponseSearchDeal>, t: Throwable) {
                view.onGetDealSearchFailure(t.message?:"통신오류")
            }
        })
    }
}