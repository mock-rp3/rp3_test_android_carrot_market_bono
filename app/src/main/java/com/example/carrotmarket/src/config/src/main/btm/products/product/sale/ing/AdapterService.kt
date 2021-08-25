package com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.models.StatusRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdapterService(val view: AdapterView) {

    fun tryPatchStatus(statusRequest: StatusRequest) {
        val statusRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        statusRetrofitInterface.patchStatus(statusRequest).enqueue(object :
            Callback<BaseResponse> {
            override fun onResponse(
                call: Call<BaseResponse>,
                response: Response<BaseResponse>,
            ) {
                view.onPatchStatusSuccess(response.body() as BaseResponse)

            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onPatchStatusFailure(t.message ?: "통신오류")
            }

        }
        )
    }
}