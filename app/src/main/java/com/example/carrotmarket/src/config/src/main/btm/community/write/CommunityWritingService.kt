package com.example.carrotmarket.src.config.src.main.btm.community.write

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.community.write.models.CWritingRequest
import com.example.carrotmarket.src.config.src.main.btm.community.write.models.CWritingResponse
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.RequestPostWriting
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.ResponseWriting
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommunityWritingService(val view:CommunityWritingActivityView) {


    fun tryPostCommunityWriting(cWritingRequest: CWritingRequest) {
        val communityRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        communityRetrofitInterface.postCommunity(cWritingRequest).enqueue(object :
            Callback<CWritingResponse> {
            override fun onResponse(
                call: Call<CWritingResponse>,
                response: Response<CWritingResponse>,
            ) {
                view.onPostCommunityWritingSuccess(response.body() as CWritingResponse)
            }

            override fun onFailure(call: Call<CWritingResponse>, t: Throwable) {
                view.onPostCommunityWritingFailure(t.message ?: "통신오류")
            }
        })
    }
}