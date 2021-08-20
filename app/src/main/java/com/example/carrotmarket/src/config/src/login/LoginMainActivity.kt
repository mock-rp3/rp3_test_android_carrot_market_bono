package com.example.carrotmarket.src.login

import android.content.Intent
import android.os.Bundle
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityLoginMainBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.login.models.ResponseLogin
import com.example.carrotmarket.src.login.models.PostLoginRequest

class LoginMainActivity : BaseActivity<ActivityLoginMainBinding>(ActivityLoginMainBinding::inflate),
    LoginActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginStartBtn.setOnClickListener {
            val phoneNumber = binding.loginMainEdtId.text.toString()
            val password = binding.loginMainEdtPwd.text.toString()

            val postRequest = PostLoginRequest(
                phoneNumber = phoneNumber,
                password = password
            )
            LoginService(this).tryPostLogin(postRequest)

        }
    }

    override fun onPostLoginSuccess(response: ResponseLogin) {
        response.message?.let { showCustomToast(it) }


//        sSharedPreferences = getSharedPreferences(X_ACCESS_TOKEN, MODE_PRIVATE)
//
//        var editor = sSharedPreferences.edit()
//        editor.putString(X_ACCESS_TOKEN, response.result.authJwt)
//        editor.commit()
//
//        Log.e("jwt123", editor.putString(X_ACCESS_TOKEN, response.result.authJwt).toString())



        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onPostLoginFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}