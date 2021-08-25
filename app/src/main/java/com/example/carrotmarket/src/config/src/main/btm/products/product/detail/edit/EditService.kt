package com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit.models.EditRequest
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit.models.EditResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditService(val view: EditActivityView) {

    fun tryPatchProductDetail(productIdx:Int,editRequest: EditRequest) {
        val productEditRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        productEditRetrofitInterface.patchProductDetail(productIdx,editRequest).enqueue(object :
            Callback<EditResponse> {
            override fun onResponse(
                call: Call<EditResponse>,
                response: Response<EditResponse>,
            ) {
                view.onPatchProductDetailSuccess(response.body() as EditResponse)

            }

            override fun onFailure(call: Call<EditResponse>, t: Throwable) {
                view.onPatchProductDetailFailure(t.message ?: "통신오류")
            }

        }
        )
    }

}