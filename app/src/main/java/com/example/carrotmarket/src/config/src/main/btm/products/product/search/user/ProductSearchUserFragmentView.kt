package com.example.carrotmarket.src.config.src.main.btm.products.product.search.user

import com.example.carrotmarket.src.config.src.main.btm.products.product.search.user.models.UserResponse

interface ProductSearchUserFragmentView {


    fun onGetUserSearchSuccess(response: UserResponse)
    fun onGetUserSearchFailure(message: String)
}