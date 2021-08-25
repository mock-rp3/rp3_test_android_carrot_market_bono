package com.example.carrotmarket.src.config.src.main.btm.products.category.select

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.category.select.models.CategorySelectResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategorySelectService(val view: CategorySelectView) {

    fun tryGetCategory(category:Int) {
        val categoryRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        categoryRetrofitInterface.getCate(category).enqueue(object :
            Callback<CategorySelectResponse> {
            override fun onResponse(
                call: Call<CategorySelectResponse>,
                response: Response<CategorySelectResponse>,
            ) {
                view.onGetCategorySuccess(response.body() as CategorySelectResponse)

            }

            override fun onFailure(call: Call<CategorySelectResponse>, t: Throwable) {
                view.onGetCategoryFailure(t.message ?: "통신오류")
            }

        }
        )
    }

}