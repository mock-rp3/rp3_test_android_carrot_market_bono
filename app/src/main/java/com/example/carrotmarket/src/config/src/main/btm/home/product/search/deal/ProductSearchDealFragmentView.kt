package com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal

import com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.models.ResponseSearchDeal

interface ProductSearchDealFragmentView {


    fun onGetDealSearchSuccess(response: ResponseSearchDeal)
    fun onGetDealSearchFailure(message: String)
}