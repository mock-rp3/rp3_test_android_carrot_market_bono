package com.example.carrotmarket.src

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity  : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
//
//        binding.mainBtmNav.setOnNavigationItemSelectedListener(
//            BottomNavigationView.OnNavigationItemSelectedListener { item ->
//                when (item.itemId) {
//                    R.id.menu_main_btm_nav_home -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.main_frm, HomeFragment())
//                            .commitAllowingStateLoss()
//                        return@OnNavigationItemSelectedListener true
//                    }
//                    R.id.menu_main_btm_nav_my_page -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.main_frm, MyPageFragment())
//                            .commitAllowingStateLoss()
//                        return@OnNavigationItemSelectedListener true
//                    }
//                    R.id.menu_main_btm_nav_test -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.main_frm, TestFragment())
//                            .commitAllowingStateLoss()
//                        return@OnNavigationItemSelectedListener true
//                    }
//                }
//                false
//            })


    }
}