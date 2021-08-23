package com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.models.ResponseSearchDeal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductSearchService(val view: ProductSearchDealFragmentView) {




    fun tryGetDealSearch(title: String){

        val productSearchRetrofitInterface = ApplicationClass.sRetrofit.create(ProductSearchRetrofitInterface::class.java)
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