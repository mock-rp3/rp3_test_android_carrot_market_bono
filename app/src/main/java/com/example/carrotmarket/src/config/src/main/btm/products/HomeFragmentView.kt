package com.example.carrotmarket.src.config.src.main.btm.products

import com.example.carrotmarket.src.config.src.main.btm.products.models.ResponseHome

interface HomeFragmentView {

    fun onGetProductSuccess(response: ResponseHome)
    fun onGetProductFailure(message: String)

}