package com.example.carrotmarket.src.config.src.main

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.example.carrotmarket.src.config.src.main.btm.AroundFragment
import com.example.carrotmarket.src.config.src.main.btm.ChatFragment
import com.example.carrotmarket.src.config.src.main.btm.LifeFragment
import com.example.carrotmarket.src.config.src.product.ProductWriteActivity
import com.example.carrotmarket.src.config.src.users.MyPageFragment
import com.example.carrotmarket.src.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private var isFabOpen = false

    private var fabState: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        when (fabState) {
            1 -> {
//                binding.fabMain.visibility = View.VISIBLE
            }
            2 -> {
//                binding.fabMain.setImageResource(R.drawable.pencil_icon)
//                binding.fabMain.visibility = View.VISIBLE
            }
            3 -> {
//                binding.fabMain.visibility = View.GONE
//                binding.homeFab1.visibility = View.GONE
//                binding.homeFab2.visibility = View.GONE
            }
            4 -> {
//                binding.fabMain.visibility = View.GONE
            }
            5 -> {
//                binding.fabMain.visibility = View.GONE
            }
        }


        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->

                when (item.itemId) {
                    R.id.menu_main_btm_nav_1_on -> {
//                        fabState=1
//                        binding.fabMain.setImageResource(R.drawable.bottom_floating_btn_icon)
//                        binding.fabMain.visibility = View.VISIBLE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_2_off -> {
//                        binding.fabMain.setImageResource(R.drawable.pencil_icon)
//                        binding.fabMain.visibility = View.VISIBLE
//                        fabState=2
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, LifeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_3_off -> {
//                        fabState=3
//                        binding.fabMain.visibility = View.GONE
//                        binding.homeFab1.visibility = View.GONE
//                        binding.homeFab2.visibility = View.GONE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, AroundFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_4_off -> {
//                        fabState=4
//                        binding.fabMain.visibility = View.GONE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ChatFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_5_off -> {
//                        fabState = 5
//                        binding.fabMain.visibility = View.GONE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyPageFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }

                }
                false
            })


        binding.fabMain.setOnClickListener {
            if(fabState ==1) {
                toggleFab()
            }else if(fabState ==2){
                intent = Intent(this, ProductWriteActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.homeFab1.setOnClickListener {

        }

        // 플로팅 버튼 클릭 이벤트 - 수정
        binding.homeFab2.setOnClickListener {
            intent=Intent(this,ProductWriteActivity::class.java)
            startActivity(intent)
            finish()
        }


        binding.homeViBack.setOnClickListener {
            binding.homeViBack.visibility = View.GONE
            binding.homeFab1.hide()
            binding.homeFab2.hide()
            ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 135f, 0f).apply { start() }
            isFabOpen = false
            binding.homeTxtFab1Info.visibility = View.GONE
            binding.homeTxtFab2Info.visibility = View.GONE
        }


    }

    private fun toggleFab() {
        // 플로팅 액션 버튼 닫기 - 열려있는 플로팅 버튼 집어넣는 애니메이션 세팅
        if (isFabOpen) {
            //TranslationY 는 상하방향, TranslationX는 좌우 방향, View.ROTATION은 회전을 구현 할 수 있다.
//            ObjectAnimator.ofFloat(binding.fabCamera, "translationY", 0f).apply { start() }
//            ObjectAnimator.ofFloat(binding.fabEdit, "translationY", 0f).apply { start() }
            binding.homeViBack.visibility = View.GONE
//            binding.fabEdit.visibility = View.INVISIBLE
//            binding.fabCamera.visibility = View.INVISIBLE
            binding.homeFab1.hide()
            binding.homeFab2.hide()
            binding.homeTxtFab1Info.visibility = View.GONE
            binding.homeTxtFab2Info.visibility = View.GONE
            ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 135f, 0f).apply { start() }
//            binding.fabMain.setImageResource(R.drawable.bottom_floating_btn_icon)

            // 플로팅 액션 버튼 열기 - 닫혀있는 플로팅 버튼 꺼내는 애니메이션 세팅
        } else {
            binding.homeViBack.bringToFront() // 최상단으로 보내주기
            binding.homeTxtFab2Info.bringToFront()
            binding.homeTxtFab1Info.bringToFront()
//            ObjectAnimator.ofFloat(binding.fabCamera, "translationY", -340f).apply { start() }
//            ObjectAnimator.ofFloat(binding.fabEdit, "translationY", -180f).apply { start() }
            binding.homeViBack.visibility = View.VISIBLE
            binding.homeTxtFab1Info.visibility = View.VISIBLE
            binding.homeTxtFab2Info.visibility = View.VISIBLE
//            binding.fabEdit.visibility = View.VISIBLE
//            binding.fabCamera.visibility = View.VISIBLE

            binding.homeFab1.show()
            binding.homeFab2.show()

            ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 0f, 135f).apply { start() }

//            binding.fabMain.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));

        }

        isFabOpen = !isFabOpen

    }
}