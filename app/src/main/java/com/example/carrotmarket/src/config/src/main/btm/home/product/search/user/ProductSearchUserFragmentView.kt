package com.example.carrotmarket.src.config.src.main.btm.home.product.search.user

import com.example.carrotmarket.src.config.src.main.btm.home.product.search.user.models.UserResponse

interface ProductSearchUserFragmentView {


    fun onGetUserSearchSuccess(response: UserResponse)
    fun onGetUserSearchFailure(message: String)
}