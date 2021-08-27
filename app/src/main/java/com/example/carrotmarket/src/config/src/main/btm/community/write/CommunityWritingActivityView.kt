package com.example.carrotmarket.src.config.src.main.btm.community.write

import com.example.carrotmarket.src.config.src.main.btm.community.write.models.CWritingResponse

interface CommunityWritingActivityView {

    fun onPostCommunityWritingSuccess(response: CWritingResponse)
    fun onPostCommunityWritingFailure(message: String)
}