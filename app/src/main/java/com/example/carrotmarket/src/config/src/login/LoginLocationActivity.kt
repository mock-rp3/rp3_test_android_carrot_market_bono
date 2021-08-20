package com.example.carrotmarket.src.login

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityLoginLocationBinding


data class Location(
    val location: String,
)


class LoginLocationActivity :
    BaseActivity<ActivityLoginLocationBinding>(ActivityLoginLocationBinding::inflate) {

    var locationArrayList = ArrayList<Location>()

    private lateinit var loginLocationAdapter: LoginLocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginLocationAdapter = LoginLocationAdapter(this, locationArrayList)

        binding.loginLocationRvAround.adapter = loginLocationAdapter

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


}