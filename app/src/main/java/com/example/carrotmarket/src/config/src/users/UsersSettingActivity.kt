package com.example.carrotmarket.src.config.src.users

import android.content.Intent
import android.os.Bundle
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityUsersSettingBinding
import com.example.carrotmarket.src.StartActivity
import com.example.carrotmarket.src.config.src.main.MainActivity

class UsersSettingActivity:BaseActivity<ActivityUsersSettingBinding>(ActivityUsersSettingBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.userSettingImgBack.setOnClickListener {
            intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.userSettingLogout.setOnClickListener {
            intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}