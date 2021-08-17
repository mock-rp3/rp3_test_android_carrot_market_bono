package com.example.carrotmarket.src.splash

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivitySplashBinding
import com.example.carrotmarket.src.StartActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, StartActivity::class.java))
            finish()
        }, 1500)


    }
}