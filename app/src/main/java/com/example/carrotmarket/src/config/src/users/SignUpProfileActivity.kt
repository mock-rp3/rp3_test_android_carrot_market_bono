package com.example.carrotmarket.src.users

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.config.ApplicationClass.Companion.sSharedPreferences
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivitySignUpProfileBinding
import com.example.carrotmarket.src.login.LoginLocationActivity
import com.example.carrotmarket.src.users.models.PostSignUpRequest
import com.example.carrotmarket.src.users.models.SignUpResponse

class SignUpProfileActivity :
    BaseActivity<ActivitySignUpProfileBinding>(ActivitySignUpProfileBinding::inflate),
    SignUpActivityView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpBtnNext.setOnClickListener {

            val phoneNumber=intent.getStringExtra("phoneNumber")
            val password =intent.getStringExtra("password")
            val nickname = binding.signUpEdtNick.text.toString()
            val profileImageUrl = binding.signUpImgProfile.toString()

            val postRequest = PostSignUpRequest(
                phoneNumber = phoneNumber!!,
                password = password!!,
                nickname = nickname,
                profileImageUrl = "https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg")

            showLoadingDialog(baseContext!!)
            SignUpService(this).tryPostSignUp(postRequest)
        }

    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
        sSharedPreferences = getSharedPreferences(X_ACCESS_TOKEN, MODE_PRIVATE)

        var editor = sSharedPreferences.edit()
        editor.putString(X_ACCESS_TOKEN, response.result.jwt)
        editor.commit()

        Log.e("jwt123", editor.putString(X_ACCESS_TOKEN, response.result.jwt).toString())
        response.message?.let { showCustomToast(it) }
        intent = Intent(this, LoginLocationActivity::class.java)
        startActivity(intent)
        finish()

    }

    override fun onPostSignUpFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}
