package com.example.carrotmarket.src.config.src.users.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProfilePatchBinding
import com.example.carrotmarket.src.config.src.users.profile.models.ResponseProfile
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*


class ProfilePatchActivity :
    BaseActivity<ActivityProfilePatchBinding>(ActivityProfilePatchBinding::inflate),
    ProfilePatchActivityView {

    private val PICK_IMAGE = 1
    private lateinit var storageReference: StorageReference
    private lateinit var firebaseStorage: FirebaseStorage

    lateinit var uri:Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = firebaseStorage.reference

        binding.signUpImgProfile.setOnClickListener {
            var intent = Intent(Intent.ACTION_PICK) // 이미지 가져오기
            intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*")
            startActivityForResult(intent, PICK_IMAGE)
        }

        // jwt 가져오기
        ApplicationClass.sSharedPreferences =
            getSharedPreferences(ApplicationClass.X_ACCESS_TOKEN, MODE_PRIVATE)
        val jwt =
            ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)!!
        Log.e("jwt10", jwt.toString())

        // userIdx 가져오기
        ApplicationClass.sSharedPreferences =
            getSharedPreferences("userIdx", MODE_PRIVATE)

        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0)
        Log.e("userIdx2", userIdx.toString())
        val nickname=binding.signUpEdtNick.text.toString()

        binding.signUpBtnNext.setOnClickListener{
//            ProfilePatchService(this).tryPatchProfile(jwt, userIdx)

//            ProfilePatchService(this).tryPatchProfile(uri,nickname)
            ProfilePatchService(this).tryGetJwt(jwt,userIdx)
        }


    }

    fun done() {
        val ref: StorageReference =
            storageReference.child("images/" + UUID.randomUUID().toString())
        ref.putFile(uri).addOnSuccessListener { taskSnapshot ->
            taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
//                ProfilePatchService(this).tryPatchProfile(jwt, userIdx)
            }
        }
    }



//    fun onPatchProfileSuccess(@Nullable data: Intent?) {
//        if (data != null && data.data != null) {
//            val imageUri: Uri? = data.data
//            binding.signUpImgProfile.setImageURI(imageUri)
////            binding.signUpImgProfile.setBackgroundResource(R.drawable.profile)
//            binding.signUpImgProfile.background = resources.getDrawable(com.example.carrotmarket.R.drawable.image_rounding_oval)
//            binding.signUpImgProfile.clipToOutline = true
//            uri = imageUri!!
//        }
//        super.onPatch
//    }

    override fun onPatchProfileSuccess(response: ResponseProfile) {

    }

    override fun onPatchProfileFailure(message: String) {
    }


}