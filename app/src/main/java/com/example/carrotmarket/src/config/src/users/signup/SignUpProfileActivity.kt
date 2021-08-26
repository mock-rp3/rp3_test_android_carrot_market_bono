package com.example.carrotmarket.src.config.src.users.signup

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.annotation.Nullable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivitySignUpProfileBinding
import com.example.carrotmarket.src.config.src.users.profile.ProfilePatchService
import com.example.carrotmarket.src.config.src.users.profile.models.RequestProfile
import com.example.carrotmarket.src.config.src.users.profile.models.ResponseProfile
import com.example.carrotmarket.src.login.LoginMainActivity
import com.example.carrotmarket.src.config.src.users.signup.models.PostSignUpRequest
import com.example.carrotmarket.src.config.src.users.signup.models.SignUpResponse
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

class SignUpProfileActivity :
    BaseActivity<ActivitySignUpProfileBinding>(ActivitySignUpProfileBinding::inflate),
    SignUpActivityView  {

    private val PICK_IMAGE = 1
    private lateinit var storageReference: StorageReference
    private lateinit var firebaseStorage: FirebaseStorage
    var uri: Uri? = null

    //퍼미션 응답 처리 코드
    private val multiplePermissionsCode = 100

    //필요한 퍼미션 리스트
    //원하는 퍼미션을 이곳에 추가하면 된다.
    private val requiredPermissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_PHONE_STATE,
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseStorage=FirebaseStorage.getInstance()
        storageReference=firebaseStorage.reference





//        val storageRef = storage
        binding.signUpImgProfile.setOnClickListener {
//            var intent = Intent(Intent.ACTION_PICK) // 이미지 가져오기
//            intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                "image/*")
//            startActivityForResult(intent, PICK_IMAGE)

            checkPermissions()
            var intent = Intent(Intent.ACTION_PICK) // 이미지 가져오기
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*")
            Log.e("image",
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    "image/*").toString())
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

            val ref: StorageReference =
                storageReference.child("images/" + UUID.randomUUID().toString())

            val phoneNumber = intent.getStringExtra("phoneNumber")
            val password = intent.getStringExtra("password")
            val nickname = binding.signUpEdtNick.text.toString()


//            val ref: StorageReference =
//                storageReference.child("images/" + UUID.randomUUID().toString())
//
//            //로컬 파일에서 업로드
//            ref.putFile(uri!!).addOnSuccessListener { taskSnapshot ->
//                taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
//
//                    response.result.profileImageUrl = uri.toString()
//
////                var mGlideRequestManager : RequestManager =
////                mGlideRequestManager
//                    Glide.with(this)
//                        .load(response.result.profileImageUrl)
//                        .into(binding.signUpImgProfile)
//                }
//            }

            ref.putFile(uri!!).addOnSuccessListener { taskSnapshot ->
                taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
                    val postRequest = PostSignUpRequest(
                        phoneNumber = phoneNumber!!,
                        password = password!!,
                        nickname = nickname,
                        profileImageUrl =uri.toString())

//                    showLoadingDialog(this)
                    SignUpService(this).tryPostSignUp(postRequest)
                }
            }
        }

    }



    override fun onPostSignUpSuccess(response: SignUpResponse) {
//        dismissLoadingDialog()

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


    private fun checkPermissions() {
        //거절되었거나 아직 수락하지 않은 권한(퍼미션)을 저장할 문자열 배열 리스트
        var rejectedPermissionList = ArrayList<String>()

        //필요한 퍼미션들을 하나씩 끄집어내서 현재 권한을 받았는지 체크
        for(permission in requiredPermissions){
            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                //만약 권한이 없다면 rejectedPermissionList에 추가
                rejectedPermissionList.add(permission)
            }
        }
        //거절된 퍼미션이 있다면...
        if(rejectedPermissionList.isNotEmpty()){
            //권한 요청!
            val array = arrayOfNulls<String>(rejectedPermissionList.size)
            ActivityCompat.requestPermissions(this, rejectedPermissionList.toArray(array), multiplePermissionsCode)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            multiplePermissionsCode -> {
                if(grantResults.isNotEmpty()) {
                    for((i, permission) in permissions.withIndex()) {
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            //권한 획득 실패
                            Log.i("TAG", "The user has denied to $permission")
                            Log.i("TAG", "I can't work for you anymore then. ByeBye!")

                            //finish()!!!!!!!!!!!?????

                        }
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.data != null) {
            val selectedImageUri = data.data
            binding.signUpImgProfile.setImageURI(selectedImageUri)
            binding.signUpImgProfile.background = resources.getDrawable(R.drawable.image_rounding_oval)
            binding.signUpImgProfile.clipToOutline = true
            uri = selectedImageUri
        }
        super.onActivityResult(requestCode, resultCode, data)
    }




}
