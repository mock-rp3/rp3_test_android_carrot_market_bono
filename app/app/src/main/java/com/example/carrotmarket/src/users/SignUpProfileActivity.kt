package com.example.carrotmarket.src.users

import android.content.Intent
import android.os.Bundle
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivitySignUpProfileBinding
import com.example.carrotmarket.src.StartActivity
import com.example.carrotmarket.src.login.LoginLocationActivity
import com.example.carrotmarket.src.users.models.PostSignUpRequest
import com.example.carrotmarket.src.users.models.SignUpResponse

class SignUpProfileActivity :
    BaseActivity<ActivitySignUpProfileBinding>(ActivitySignUpProfileBinding::inflate),
UsersActivityView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpBtnNext.setOnClickListener {

            val userID=intent.getStringExtra("userID")
            val password =intent.getStringExtra("password")
            val nickname = binding.signUpEdtNick.text.toString()
            val profileImageUrl = binding.signUpImgProfile.toString()

            val postRequest = PostSignUpRequest(
                userID = userID!!,
                password = password!!,
                nickname = nickname,
                profileImageUrl = "https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg")
            UsersService(this).tryPostSignUp(postRequest)
        }

    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        response.message?.let { showCustomToast(it) }
        intent = Intent(this, LoginLocationActivity::class.java)
        startActivity(intent)
        finish()

    }

    override fun onPostSignUpFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}
