package com.example.carrotmarket.src.users

import android.content.Intent
import android.os.Bundle
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivitySignUpMainBinding

class SignUpMainActivity :
    BaseActivity<ActivitySignUpMainBinding>(ActivitySignUpMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.signUpMainStartBtn.setOnClickListener {

            intent = Intent(this, SignUpProfileActivity::class.java)
            intent.putExtra("userID",binding.signUpMainEdtId.text.toString())
            intent.putExtra("password",binding.signUpMainEdtPwd.text.toString())
            startActivity(intent)
            finish()

        }

    }
}