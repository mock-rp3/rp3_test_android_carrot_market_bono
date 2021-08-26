package com.example.carrotmarket.src.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.config.ApplicationClass.Companion.sSharedPreferences
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
//            val password = binding.loginMainEdtPwd.text.toString()

            val postRequest = PostLoginRequest(
                phoneNumber = phoneNumber,
//                password = password
            )
            showLoadingDialog(this)
            LoginService(this).tryPostLogin(postRequest)

        }
    }

    override fun onPostLoginSuccess(response: ResponseLogin) {
        dismissLoadingDialog()
        response.message?.let { showCustomToast(it) }


        // 토큰 값 넣어주기
//        sSharedPreferences = getSharedPreferences(X_ACCESS_TOKEN, MODE_PRIVATE)
//        var editor = sSharedPreferences.edit()
//        editor.putString(X_ACCESS_TOKEN, response.result.authJwt)
//        editor.commit()



        // userIdx 넣어주기
//        sSharedPreferences = getSharedPreferences("userIdx", MODE_PRIVATE)
//        var editor2 = sSharedPreferences.edit()
//        editor2.putInt("userIdx", response.result.userInfoIdx)
//        editor2.commit()


        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onPostLoginFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}