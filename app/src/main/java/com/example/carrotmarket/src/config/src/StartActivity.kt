package com.example.carrotmarket.src

import android.content.Intent
import android.os.Bundle
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityStartBinding
import com.example.carrotmarket.src.login.LoginLocationActivity

class StartActivity: BaseActivity<ActivityStartBinding>(ActivityStartBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginStartBtn.setOnClickListener {
            intent = Intent(this, LoginLocationActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}