package com.example.carrotmarket.src.login

import android.os.Bundle
import android.view.View
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityLoginStartBinding

class LoginStartActivity: BaseActivity<ActivityLoginStartBinding>(ActivityLoginStartBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }
    }
}