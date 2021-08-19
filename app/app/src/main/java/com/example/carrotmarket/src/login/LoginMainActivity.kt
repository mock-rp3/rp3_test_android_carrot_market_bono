package com.example.carrotmarket.src.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityLoginMainBinding
import com.example.carrotmarket.src.MainActivity
import com.example.carrotmarket.src.login.models.LoginResponse
import com.example.carrotmarket.src.login.models.PostLoginRequest

class LoginMainActivity : BaseActivity<ActivityLoginMainBinding>(ActivityLoginMainBinding::inflate),
    LoginActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginStartBtn.setOnClickListener {
            val userID = binding.loginMainEdtId.text.toString()
            val password = binding.loginMainEdtPwd.text.toString()

            val postRequest = PostLoginRequest(
                userID = userID,
                password = password
            )
            LoginService(this).tryPostLogin(postRequest)

        }
    }

    override fun onDestroy() {
        super.onDestroy()


    }


    override fun onPostLoginSuccess(response: LoginResponse) {
        response.message?.let { showCustomToast(it) }
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onPostLoginFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}