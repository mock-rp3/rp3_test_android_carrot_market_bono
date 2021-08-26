package com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal

import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSearchDeal
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSug

interface ProductSearchDealFragmentView {


    fun onGetSuggestSuccess(response: ResponseSug)
    fun onGetSuggestFailure(message: String)
}