package com.example.carrotmarket.src.config.src.users.signup

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivitySignUpProfileBinding
import com.example.carrotmarket.src.login.LoginMainActivity
import com.example.carrotmarket.src.config.src.users.signup.models.PostSignUpRequest
import com.example.carrotmarket.src.config.src.users.signup.models.SignUpResponse
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class SignUpProfileActivity :
    BaseActivity<ActivitySignUpProfileBinding>(ActivitySignUpProfileBinding::inflate),
    SignUpActivityView {

    private val PICK_IMAGE = 1
    private lateinit var storageReference:StorageReference
    private lateinit var firebaseStorage: FirebaseStorage


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseStorage=FirebaseStorage.getInstance()
        storageReference=firebaseStorage.reference




//        val storageRef = storage
        binding.signUpImgProfile.setOnClickListener {
            var intent = Intent(Intent.ACTION_PICK) // 이미지 가져오기
            intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*")
            startActivityForResult(intent, PICK_IMAGE)
        }


        binding.signUpEdtNick.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.signUpEdtNick.length() > 1) {
                    binding.signUpBtnNext.setBackgroundColor(Color.parseColor("#FFee8548"))
                } else {
                    binding.signUpBtnNext.setBackgroundColor(Color.parseColor("#FFdcdee2"))
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        binding.signUpBtnNext.setOnClickListener {



            val phoneNumber = intent.getStringExtra("phoneNumber")
            val password = intent.getStringExtra("password")
            val nickname = binding.signUpEdtNick.text.toString()
            val profileImageUrl = binding.signUpImgProfile.toString()

            val postRequest = PostSignUpRequest(
                phoneNumber = phoneNumber!!,
                password = password!!,
                nickname = nickname,
                profileImageUrl = "https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg")




            showLoadingDialog(this)
            SignUpService(this).tryPostSignUp(postRequest)
        }

    }


    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()


//        val imageUri: Uri = ContactsContract.Data
        // 토큰 값 넣어주기
//        sSharedPreferences = getSharedPreferences(X_ACCESS_TOKEN, MODE_PRIVATE)
//        var editor = sSharedPreferences.edit()
//        editor.putString(X_ACCESS_TOKEN, response.result.jwt)
//        editor.commit()
//
//        Log.e("jwt123", editor.putString(X_ACCESS_TOKEN, response.result.jwt).toString())




        response.message?.let { showCustomToast("회원가입 성공!") }
        intent = Intent(this, LoginMainActivity::class.java)
        startActivity(intent)
        finish()

    }

    override fun onPostSignUpFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}
