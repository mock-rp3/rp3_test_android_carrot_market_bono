package com.example.carrotmarket.src.config.src.main.btm.community

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.community.models.CommunityResponse
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResponseHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommunityService(val view: CommunityFragmentView) {


    fun tryCommunityHome() {
        val communityRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        communityRetrofitInterface.getCommunity().enqueue(object :
            Callback<CommunityResponse> {
            override fun onResponse(
                call: Call<CommunityResponse>,
                response: Response<CommunityResponse>,
            ) {
                view.onGetCommunitySuccess(response.body() as CommunityResponse)

            }

            override fun onFailure(call: Call<CommunityResponse>, t: Throwable) {
                view.onGetCommunityFailure(t.message ?: "통신오류")
            }

        }
        )
    }
}