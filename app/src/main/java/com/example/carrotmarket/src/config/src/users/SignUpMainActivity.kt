package com.example.carrotmarket.src.users

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivitySignUpMainBinding
import java.util.*
import kotlin.concurrent.timer


class SignUpMainActivity :
    BaseActivity<ActivitySignUpMainBinding>(ActivitySignUpMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //TextWatcher를 사용하여 실시간 입력 동작 확인
        binding.signUpMainEdtId.addTextChangedListener(object : TextWatcher {
            //입력하기 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            //변화가 있을 때
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.signUpMainEdtId.length() > 3) {
                    binding.signUpMainBtnNext.setCardBackgroundColor(Color.parseColor("#4d5158"))

                    // 비밀번호 입력하기 버튼을 누르면
                    binding.signUpMainBtnNext.setOnClickListener {
                        binding.signUpMainMainLl.visibility = View.GONE
                        binding.signUpMainTxtModi.visibility = View.INVISIBLE
                        binding.signUpMainTxtFoundId.visibility = View.INVISIBLE
                        binding.signUpMainEdtPwd.visibility = View.VISIBLE
                        binding.signUpMainTxtWarn.visibility = View.VISIBLE
                        binding.signUpMainPwTimer.visibility = View.VISIBLE
                        binding.signUpBtnPwConfirm.visibility = View.VISIBLE
                        binding.signUpMainBtnNext.setCardBackgroundColor(Color.parseColor("#4d5158"))

                        //타이머 시작
                        startTimer()

                    }

                } else {
                    binding.signUpMainBtnNext.setCardBackgroundColor(Color.parseColor("#FFdcdee2"))
                }
            }

            //입력이 끝나면
            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.signUpMainEdtPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.signUpMainEdtPwd.length() > 3) {
                    binding.signUpBtnPwConfirm.setCardBackgroundColor(Color.parseColor("#FFee8548"))
                } else if (binding.signUpMainEdtPwd.length() == 0) {
                    binding.signUpBtnPwConfirm.setCardBackgroundColor(Color.parseColor("#FFdcdee2"))

                    binding.signUpBtnPwConfirm.setOnClickListener {
                        intent = Intent(this@SignUpMainActivity, SignUpProfileActivity::class.java)
                        intent.putExtra("userID", binding.signUpMainEdtId.text.toString())
                        intent.putExtra("password", binding.signUpMainEdtPwd.text.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

    }

    // 타이머
    private var time = 300
    private var timerTask: Timer? = null
    private fun startTimer() {
        timerTask = timer(period = 1000) {

            time--

            val min = time / 60
            val sec = time - (60 * min)

            runOnUiThread {
                binding.signUpMainPwTimer.text = "${min}분 ${sec}초"

                // 0초가 되면 멈추도록
                if (time == 0) {
                    timerTask?.cancel()
                }
            }
        }
    }
}