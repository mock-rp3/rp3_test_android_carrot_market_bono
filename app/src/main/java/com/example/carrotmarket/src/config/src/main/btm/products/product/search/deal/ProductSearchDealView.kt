package com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal

import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSearchDeal

interface ProductSearchDealView {

    fun onGetDealSearchSuccess(response: ResponseSearchDeal)
    fun onGetDealSearchFailure(message: String)
}