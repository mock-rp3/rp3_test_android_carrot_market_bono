package com.example.carrotmarket.src.config.src.users.signup

import com.example.carrotmarket.src.config.src.users.signup.models.SignUpResponse

interface SignUpActivityView {
    fun onPostSignUpSuccess(response: SignUpResponse)
    fun onPostSignUpFailure(message: String)

}