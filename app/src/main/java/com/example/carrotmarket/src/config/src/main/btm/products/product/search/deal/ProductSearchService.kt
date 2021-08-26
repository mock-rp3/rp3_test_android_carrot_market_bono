package com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSearchDeal
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductSearchService(val view: ProductSearchDealFragmentView) {

    fun tryGetSuggest(){
        val suggestRetrofitInterface = ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        suggestRetrofitInterface.getSuggest().enqueue(object  : Callback<ResponseSug> {
            override fun onResponse(
                call: Call<ResponseSug>,
                response: Response<ResponseSug>
            ) {

                view.onGetSuggestSuccess(response.body() as ResponseSug)
            }

            override fun onFailure(call: Call<ResponseSug>, t: Throwable) {
                view.onGetSuggestFailure(t.message?:"통신오류")
            }
        })
    }






}