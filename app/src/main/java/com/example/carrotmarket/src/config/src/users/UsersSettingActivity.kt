package com.example.carrotmarket.src.config.src.users

import android.content.Intent
import android.os.Bundle
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityUsersSettingBinding

class UsersSettingActivity:BaseActivity<ActivityUsersSettingBinding>(ActivityUsersSettingBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.userSettingImgBack.setOnClickListener {
            intent= Intent(this, MyPageFragment::class.java)
            startActivity(intent)
            finish()
        }
    }
}