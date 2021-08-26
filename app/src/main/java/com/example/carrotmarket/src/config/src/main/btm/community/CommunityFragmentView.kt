package com.example.carrotmarket.src.config.src.main.btm.community

import com.example.carrotmarket.src.config.src.main.btm.community.models.CommunityResponse
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResponseHome

interface CommunityFragmentView {

    fun onGetCommunitySuccess(response: CommunityResponse)
    fun onGetCommunityFailure(message: String)

}