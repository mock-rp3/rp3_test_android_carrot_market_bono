package com.example.carrotmarket.src.config.src.users

import com.example.carrotmarket.src.config.src.users.models.MyPageResponse

interface MyPageFragmentView {

    fun onGetMyPageSuccess(response: MyPageResponse)
    fun onGetMyPageFailure(message: String)

}