package com.example.carrotmarket.src.config.src.main.btm.products.product.detail

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsRetrofitInterface
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.RequestWish
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.RequestWishDel
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResponseDetail
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResponseSellerProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailService(val view: ProductDetailActivityView) {

    fun tryGetProductDetail(productIdx:Int) {
        val productDetailRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        productDetailRetrofitInterface.getProductDetail(productIdx).enqueue(object :
            Callback<ResponseDetail> {
            override fun onResponse(
                call: Call<ResponseDetail>,
                response: Response<ResponseDetail>,
            ) {
                view.onGetProductDetailSuccess(response.body() as ResponseDetail)

            }

            override fun onFailure(call: Call<ResponseDetail>, t: Throwable) {
                view.onGetProductDetailFailure(t.message ?: "통신오류")
            }

        }
        )
    }

    fun tryDeleteProduct(productIdx:Int) {
        val productDeleteRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        productDeleteRetrofitInterface.deleteProduct(productIdx).enqueue(object :
            Callback<BaseResponse> {
            override fun onResponse(
                call: Call<BaseResponse>,
                response: Response<BaseResponse>,
            ) {
                view.onDeleteProductSuccess(response.body() as BaseResponse)

            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onDeleteProductFailure(t.message ?: "통신오류")
            }

        }
        )
    }

    fun tryPatchViews(productIdx:Int) {
        val patchViewsRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        patchViewsRetrofitInterface.patchView(productIdx).enqueue(object :
            Callback<BaseResponse> {
            override fun onResponse(
                call: Call<BaseResponse>,
                response: Response<BaseResponse>,
            ) {
                view.onPatchViewsSuccess(response.body() as BaseResponse)

            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onGetProductDetailFailure(t.message ?: "통신오류")
            }

        }
        )
    }

    fun tryGetSellerProduct(status:String,seller: Int){
        val getSellerProductRetrofit =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        getSellerProductRetrofit.getSellerProduct(status,seller).enqueue(object :
        Callback<ResponseSellerProduct>{
            override fun onResponse(
                call: Call<ResponseSellerProduct>,
                response: Response<ResponseSellerProduct>,
            ) {
                view.onGetSellerProductSuccess(response.body() as ResponseSellerProduct)
            }

            override fun onFailure(call: Call<ResponseSellerProduct>, t: Throwable) {
                view.onGetSellerProductFailure(t.message ?: "통신오류")
            }

        }
        )
    }

    fun tryPostWishProduct(requestWish: RequestWish){
        val postWishProductRetrofit =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        postWishProductRetrofit.postWish(requestWish).enqueue(object :
            Callback<BaseResponse>{
            override fun onResponse(
                call: Call<BaseResponse>,
                response: Response<BaseResponse>,
            ) {
                view.onPostWishSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onPostWishFailure(t.message ?: "통신오류")
            }

        }
        )
    }

    fun tryDeleteWishProduct(requestWishDel: RequestWishDel){
        val deleteWishProductRetrofit =
            ApplicationClass.sRetrofit.create(ProductsRetrofitInterface::class.java)
        deleteWishProductRetrofit.deleteWish(requestWishDel).enqueue(object :
            Callback<BaseResponse>{
            override fun onResponse(
                call: Call<BaseResponse>,
                response: Response<BaseResponse>,
            ) {
                view.onDeleteProductSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onDeleteProductFailure(t.message ?: "통신오류")
            }

        }
        )
    }

}