package com.example.carrotmarket.src.users

import com.example.carrotmarket.src.users.models.SignUpResponse

interface UsersActivityView {
    fun onPostSignUpSuccess(response: SignUpResponse)
    fun onPostSignUpFailure(message: String)

}