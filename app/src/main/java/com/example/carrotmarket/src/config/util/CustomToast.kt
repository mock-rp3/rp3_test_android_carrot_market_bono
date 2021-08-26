package com.example.carrotmarket.src.config.util

import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.load.engine.Resource
import com.example.carrotmarket.R
import com.example.carrotmarket.databinding.CustomToastBinding

object CustomToast {

    fun createToast(context: Context, message: String): Toast?{
        val inflater = LayoutInflater.from(context)
        val binding: CustomToastBinding =
            DataBindingUtil.inflate(inflater, R.layout.custom_toast,null,false)

        binding.customToastMessage.text = message

        return Toast(context).apply {
//            setGravity(Gravity.BOTTOM or Gravity.CENTER,0, 16.toPx())
            duration=Toast.LENGTH_SHORT
            view = binding.root

        }

    }
//    private fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
}