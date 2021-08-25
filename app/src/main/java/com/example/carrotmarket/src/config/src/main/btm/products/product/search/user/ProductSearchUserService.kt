package com.example.carrotmarket.src.config.src.main.btm.products.product.search.user

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.user.models.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductSearchUserService(val view: ProductSearchUserFragmentView) {



    fun tryGetUserSearch(name: String){

        val productSearchUserRetrofitInterface = ApplicationClass.sRetrofit.create(
            ProductsRetrofitInterface::class.java)
        productSearchUserRetrofitInterface.getSearchUser(name).enqueue(object  :
            Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {

                view.onGetUserSearchSuccess(response.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                view.onGetUserSearchFailure(t.message?:"통신오류")
            }
        })
    }

}