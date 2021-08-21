package com.example.carrotmarket.src.config.src.users

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.config.ApplicationClass.Companion.sSharedPreferences
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentMyPageBinding
import com.example.carrotmarket.src.config.src.users.models.MyPageResponse
import com.example.carrotmarket.src.config.src.users.models.RequestMyPage
import com.example.carrotmarket.src.login.LoginMainActivity


class MyPageFragment :
    BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page),
    MyPageFragmentView {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sSharedPreferences =
            requireActivity().getSharedPreferences(X_ACCESS_TOKEN, AppCompatActivity.MODE_PRIVATE)
        val jwt = sSharedPreferences.getString(X_ACCESS_TOKEN, null)!!
        Log.e("jwt10", jwt.toString())

        sSharedPreferences =
            requireActivity().getSharedPreferences("userIdx", AppCompatActivity.MODE_PRIVATE)

        val userIdx = sSharedPreferences.getInt("userIdx", 0)
        Log.e("userIdx2", userIdx.toString())



//        MyPageService(this).tryGetMyPage(42)


        MyPageService(this).tryGetMyPage(jwt, userIdx)


//        if (jwt ==null){
//
//            var intent = Intent(context, LoginMainActivity::class.java)
//            startActivity(intent)
//        }else{

//            getProfile()
//        }


    }

    override fun onGetMyPageSuccess(response: MyPageResponse) {

//        var editor = sSharedPreferences.edit()
//
//        sSharedPreferences = requireActivity().getSharedPreferences("userIdx", Context.MODE_PRIVATE)
//        editor.putInt("userIdx", response.result.userInfoIdx)
//        editor.commit()

        binding.myPageUserName.text =
            response.result.nickname.toString()

//        binding.myPageUserName.text =
//            response.result.nickname.toString()


        Glide.with(this)
            .load(response.result.profileImageUrl)
            .into(binding.myPageImgUserProfile)

    }

    override fun onGetMyPageFailure(message: String) {

    }


}