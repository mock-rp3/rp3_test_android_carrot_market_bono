package com.example.carrotmarket.src.login

import com.example.carrotmarket.src.login.models.LoginResponse

interface LoginActivityView {

    fun onPostLoginSuccess(response: LoginResponse)
    fun onPostLoginFailure(message: String)
}