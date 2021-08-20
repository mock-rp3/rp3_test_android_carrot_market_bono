package com.example.carrotmarket.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.config.ApplicationClass.Companion.sSharedPreferences
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivitySplashBinding
import com.example.carrotmarket.src.MainActivity
import com.example.carrotmarket.src.StartActivity
import com.example.carrotmarket.src.login.LoginMainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        sSharedPreferences = getSharedPreferences(X_ACCESS_TOKEN, MODE_PRIVATE)

        val jwt = sSharedPreferences.getString(X_ACCESS_TOKEN, null)


//        Handler(Looper.getMainLooper()).postDelayed({
//            startActivity(Intent(this, StartActivity::class.java))
//            finish()
//        }, 1500)

        Handler(Looper.getMainLooper()).postDelayed({
            if (jwt == null) {
                intent = Intent(this, LoginMainActivity::class.java)
                Log.e("jwt1", getSharedPreferences(X_ACCESS_TOKEN, MODE_PRIVATE).toString())
                startActivity(intent)
                finish()
            } else {
                Log.e("jwt2", getSharedPreferences(X_ACCESS_TOKEN, MODE_PRIVATE).toString())

                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }, 1500)
    }
}