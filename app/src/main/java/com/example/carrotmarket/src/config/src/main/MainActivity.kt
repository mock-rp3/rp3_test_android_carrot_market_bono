package com.example.carrotmarket.src.config.src.main

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.example.carrotmarket.src.config.src.main.btm.AroundFragment
import com.example.carrotmarket.src.config.src.main.btm.ChatFragment
import com.example.carrotmarket.src.config.src.main.btm.community.LifeFragment
import com.example.carrotmarket.src.config.src.main.btm.community.write.CommunityWritingActivity
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.ProductWritingActivity
import com.example.carrotmarket.src.config.src.users.mypage.MyPageFragment
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
        val menu: Menu = binding.mainBtmNav.menu
//        binding.mainBtmNav.selectedItemId=R.id.menu_main_btm_nav_1_off
        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->

                when (item.itemId) {
                    R.id.menu_main_btm_nav_1_off -> {
                        fabState = 1
                        item.setIcon(R.drawable.bottom_home_on)

                        menu.findItem(R.id.menu_main_btm_nav_2_off).setIcon(R.drawable.bottom_2_off)
                        menu.findItem(R.id.menu_main_btm_nav_3_off).setIcon(R.drawable.bottom_3_off)
                        menu.findItem(R.id.menu_main_btm_nav_4_off).setIcon(R.drawable.bottom_4_off)
                        menu.findItem(R.id.menu_main_btm_nav_5_off).setIcon(R.drawable.bottom_5_off)

                        binding.fabMain.setImageResource(R.drawable.bottom_floating_btn_icon)
                        binding.fabMain.visibility = View.VISIBLE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_2_off -> {
                        fabState = 2
                        item.setIcon(R.drawable.bottom_2_on)

                        menu.findItem(R.id.menu_main_btm_nav_1_off).setIcon(R.drawable.bottom_home_off)
                        menu.findItem(R.id.menu_main_btm_nav_3_off).setIcon(R.drawable.bottom_3_off)
                        menu.findItem(R.id.menu_main_btm_nav_4_off).setIcon(R.drawable.bottom_4_off)
                        menu.findItem(R.id.menu_main_btm_nav_5_off).setIcon(R.drawable.bottom_5_off)
                        binding.fabMain.setImageResource(R.drawable.pencil_icon)
                        binding.fabMain.visibility = View.VISIBLE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, LifeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_3_off -> {
                        fabState = 3
                        item.setIcon(R.drawable.bottom_3_on)

                        menu.findItem(R.id.menu_main_btm_nav_1_off).setIcon(R.drawable.bottom_home_off)
                        menu.findItem(R.id.menu_main_btm_nav_2_off).setIcon(R.drawable.bottom_2_off)
                        menu.findItem(R.id.menu_main_btm_nav_4_off).setIcon(R.drawable.bottom_4_off)
                        menu.findItem(R.id.menu_main_btm_nav_5_off).setIcon(R.drawable.bottom_5_off)
                        binding.fabMain.visibility = View.GONE
                        binding.homeFab1.visibility = View.GONE
                        binding.homeFab2.visibility = View.GONE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, AroundFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_4_off -> {
                        fabState = 4
                        item.setIcon(R.drawable.bottom_4_on)
                        menu.findItem(R.id.menu_main_btm_nav_1_off).setIcon(R.drawable.bottom_home_off)
                        menu.findItem(R.id.menu_main_btm_nav_2_off).setIcon(R.drawable.bottom_2_off)
                        menu.findItem(R.id.menu_main_btm_nav_3_off).setIcon(R.drawable.bottom_3_off)
                        menu.findItem(R.id.menu_main_btm_nav_5_off).setIcon(R.drawable.bottom_5_off)
                        binding.fabMain.visibility = View.GONE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ChatFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_5_off -> {
                        fabState = 5
                        item.setIcon(R.drawable.bottom_5_on)
                        menu.findItem(R.id.menu_main_btm_nav_1_off).setIcon(R.drawable.bottom_home_off)
                        menu.findItem(R.id.menu_main_btm_nav_2_off).setIcon(R.drawable.bottom_2_off)
                        menu.findItem(R.id.menu_main_btm_nav_3_off).setIcon(R.drawable.bottom_3_off)
                        menu.findItem(R.id.menu_main_btm_nav_4_off).setIcon(R.drawable.bottom_4_off)
                        binding.fabMain.visibility = View.GONE
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyPageFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }

                }
                false
            })


        binding.fabMain.setOnClickListener {
            if (fabState == 1) {
                toggleFab()
            } else if (fabState == 2) {
                intent = Intent(this, CommunityWritingActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.homeFab1.setOnClickListener {

        }

        // ????????? ?????? ?????? ????????? - ??????
        binding.homeFab2.setOnClickListener {
            intent = Intent(this, ProductWritingActivity::class.java)
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
        // ????????? ?????? ?????? ?????? - ???????????? ????????? ?????? ???????????? ??????????????? ??????
        if (isFabOpen) {
            //TranslationY ??? ????????????, TranslationX??? ?????? ??????, View.ROTATION??? ????????? ?????? ??? ??? ??????.
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

            // ????????? ?????? ?????? ?????? - ???????????? ????????? ?????? ????????? ??????????????? ??????
        } else {
            binding.homeViBack.bringToFront() // ??????????????? ????????????
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