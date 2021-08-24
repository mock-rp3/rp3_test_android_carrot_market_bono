package com.example.carrotmarket.src.config.src.users.profile

import com.example.carrotmarket.src.config.src.users.models.MyPageResponse
import com.example.carrotmarket.src.config.src.users.profile.models.ResponseProfile

interface ProfilePatchActivityView {

    fun onPatchProfileSuccess(response: ResponseProfile)
    fun onPatchProfileFailure(message: String)
}