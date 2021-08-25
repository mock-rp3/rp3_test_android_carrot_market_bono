package com.example.carrotmarket.src.config.src.main.btm.products.product.detail

import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResponseDetail
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResponseSellerProduct

interface ProductDetailActivityView {

    fun onGetProductDetailSuccess(response: ResponseDetail)
    fun onGetProductDetailFailure(message: String)

    fun onDeleteProductSuccess(response: BaseResponse)
    fun onDeleteProductFailure(message: String)

    fun onPatchViewsSuccess(response: BaseResponse)
    fun onPatchViewsFailure(message: String)

    fun onGetSellerProductSuccess(response: ResponseSellerProduct)
    fun onGetSellerProductFailure(message: String)

    fun onPostWishSuccess(response: BaseResponse)
    fun onPostWishFailure(message: String)

    fun onDeleteWishSuccess(response: BaseResponse)
    fun onDeleteWishFailure(message: String)
}