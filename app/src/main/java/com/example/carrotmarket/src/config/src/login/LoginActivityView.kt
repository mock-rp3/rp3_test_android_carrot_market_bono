package com.example.carrotmarket.src.login

import com.example.carrotmarket.src.login.models.ResponseLogin

interface LoginActivityView {

    fun onPostLoginSuccess(response: ResponseLogin)
    fun onPostLoginFailure(message: String)
}