package com.example.carrotmarket.src.users

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivitySignUpMainBinding
import com.example.carrotmarket.src.config.util.CustomToast
import java.util.*
import kotlin.concurrent.timer


class SignUpMainActivity :
    BaseActivity<ActivitySignUpMainBinding>(ActivitySignUpMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //밑줄
        binding.signUpMainTxtFoundId.text = Html.fromHtml("<u>"+binding.signUpMainTxtFoundId.text+"</u>")

        //키보드 내리기


        //TextWatcher를 사용하여 실시간 입력 동작 확인
        binding.signUpMainEdtId.addTextChangedListener(object : TextWatcher {
            //입력하기 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            //변화가 있을 때
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (binding.signUpMainEdtId.length() > 9) {
                    binding.signUpMainBtnNext.setCardBackgroundColor(Color.parseColor("#4d5158"))

                    var handled = false
                    // 비밀번호 입력하기 버튼을 누르면
                    binding.signUpMainBtnNext.setOnClickListener {
                        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        inputMethodManager.hideSoftInputFromWindow(binding.signUpMainEdtId.windowToken,0)
                        handled =true

                        binding.signUpMainMainLl.visibility = View.GONE
                        binding.signUpMainTxtModi.visibility = View.GONE
                        binding.signUpMainTxtFoundId.visibility = View.GONE
                        binding.signUpMainEdtPwd.visibility = View.VISIBLE
                        binding.signUpMainTxtWarn.visibility = View.VISIBLE
                        binding.signUpMainPwTimer.visibility = View.VISIBLE
                        binding.signUpBtnPwConfirm.visibility = View.VISIBLE
                        binding.signUpMainBtnNext.setCardBackgroundColor(Color.parseColor("#4d5158"))

                        CustomToast.createToast(this@SignUpMainActivity,"인증번호가 문자로 전송됐습니다. (최대 20초 소요)")?.show()
                        //타이머 시작
                        startTimer()

                    }
                    handled

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
                if (binding.signUpMainEdtPwd.length() > 0) {
                    binding.signUpBtnPwConfirm.setCardBackgroundColor(Color.parseColor("#FFee8548"))


                    binding.signUpBtnPwConfirm.setOnClickListener {
                        intent = Intent(this@SignUpMainActivity, SignUpProfileActivity::class.java)
                        intent.putExtra("phoneNumber", binding.signUpMainEdtId.text.toString())
                        intent.putExtra("password", binding.signUpMainEdtPwd.text.toString())
                        startActivity(intent)
                        finish()
                    }

                } else if (binding.signUpMainEdtPwd.length() == 0) {
                    binding.signUpBtnPwConfirm.setCardBackgroundColor(Color.parseColor("#FFdcdee2"))


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