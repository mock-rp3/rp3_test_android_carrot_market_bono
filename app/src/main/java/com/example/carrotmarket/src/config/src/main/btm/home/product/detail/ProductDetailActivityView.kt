package com.example.carrotmarket.src.config.src.main.btm.home.product.detail

import com.example.carrotmarket.src.config.src.main.btm.home.product.detail.models.ResponseDetail

interface ProductDetailActivityView {

    fun onGetProductDetailSuccess(response: ResponseDetail)
    fun onGetProductDetailFailure(message: String)
}