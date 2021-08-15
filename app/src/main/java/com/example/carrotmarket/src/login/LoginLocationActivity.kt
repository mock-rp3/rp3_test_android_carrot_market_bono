package com.example.carrotmarket.src.login

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityLoginLocationBinding


data class Location(
    val location: String,
)


class LoginLocationActivity : BaseActivity<ActivityLoginLocationBinding>(ActivityLoginLocationBinding::inflate) {

    var locationArrayList = ArrayList<Location>()

    private lateinit var loginLocationListViewAdapter: LoginLocationListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginLocationListViewAdapter= LoginLocationListViewAdapter(this, locationArrayList)

        binding.loginLocationRvAround.adapter=loginLocationListViewAdapter

        val dividerItemDecoration = DividerItemDecoration(
            applicationContext, LinearLayoutManager(this).orientation)
        binding.loginLocationRvAround.addItemDecoration(dividerItemDecoration)

        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )
        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )

        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )
        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )
        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )

        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )
        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )
        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )

        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )
        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )
        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )

        locationArrayList.add(
            Location(
                "서울 강동구 명일제1동"
            )
        )
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }
    }
}