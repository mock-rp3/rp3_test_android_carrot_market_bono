package com.example.carrotmarket.src.config.src.main.btm.home

import com.example.carrotmarket.src.config.src.main.btm.home.models.ResponseHome

interface HomeFragmentView {

    fun onGetProductSuccess(response: ResponseHome)
    fun onGetProductFailure(message: String)

}