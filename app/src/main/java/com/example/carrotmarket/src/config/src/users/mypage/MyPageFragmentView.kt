package com.example.carrotmarket.src.config.src.users.mypage

import com.example.carrotmarket.src.config.src.users.mypage.models.MyPageResponse

interface MyPageFragmentView {

    fun onGetMyPageSuccess(response: MyPageResponse)
    fun onGetMyPageFailure(message: String)

}