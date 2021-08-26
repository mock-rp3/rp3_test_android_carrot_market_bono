package com.example.carrotmarket.src.config.src.main.btm.products.product.writing

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProductWritingBinding
import com.example.carrotmarket.src.config.src.main.MainActivity

import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.RequestPostWriting
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.ResponseWriting
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*


class ProductWritingActivity :
    BaseActivity<ActivityProductWritingBinding>(ActivityProductWritingBinding::inflate),
    ProductWritingActivityView {


    private var categoryId = 0
    private var canProposal = "N"

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
        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = firebaseStorage.reference


        // 안됨
//        if(binding.productWriteTxtNow.text.equals("1")){
//            binding.productWriteTxtNow.setTextColor(Color.parseColor("FFee8548"))
//        }

        // 카메라 누르면 이미지 가져오기
        binding.productWriteCameraImg.setOnClickListener {
            checkPermissions()
            var intent = Intent(Intent.ACTION_PICK) // 이미지 가져오기
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*")
            Log.e("image",
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    "image/*").toString())
            startActivityForResult(intent, PICK_IMAGE)

        }



        //카테고리
        binding.productWriteClCate.setOnClickListener {
            showDialog()
        }

        //edittext 글자 변화
        binding.productWritePrice.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.productWritePrice.length() > 0) {
                    binding.productWritePricePro.setTextColor(Color.parseColor("#000000"))
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        //체크박스 상태변화
        binding.productWriteCbPricePro.setOnClickListener {
            if (binding.productWriteCbPricePro.isChecked == true) {
                canProposal = "Y"
            } else {
                canProposal = "N"
            }
        }

        // userIdx 가져오기
        ApplicationClass.sSharedPreferences =
            getSharedPreferences("userIdx", AppCompatActivity.MODE_PRIVATE)

        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0)
        Log.e("userIdx2", userIdx.toString())


        binding.productWriteComp.setOnClickListener {
            val title = binding.productWriteTitle.text.toString()
            val price = binding.productWritePrice.text.toString()
            val contents = binding.productWriteContents.text.toString()

            //            val ref: StorageReference =
            //                storageReference.child("images/" + UUID.randomUUID().toString())
            //

            val ref: StorageReference =
                storageReference.child("images/" + UUID.randomUUID().toString())

            ref.putFile(uri!!).addOnSuccessListener { taskSnapshot ->
                taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
                    val requestPostWriting = RequestPostWriting(
                        title = title,
                        price = price.toInt(),
                        canProposal = canProposal,
                        categoryId = categoryId,
                        sellerId = userIdx,
                        imageUrl = uri.toString(),
                        contents = contents
                    )
                    ProductWritingService(this).tryPostProductWriting(requestPostWriting)
                    //                    showLoadingDialog(this)
                }
            }
            //                        intent.putExtra("phoneNumber", binding.signUpMainEdtId.text.toString())
            //                        intent.putExtra("password", binding.signUpMainEdtPwd.text.toString())
//            intent.putExtra("title",title)
//            intent.putExtra("price",price)
//            intent.putExtra("canProposal",canProposal)
//            intent.putExtra("categoryId",categoryId)
//            intent.putExtra("sellerId",userIdx)
//            intent.putExtra("imageUrl", "test")
//            intent.putExtra("contents",contents)


//            supportFragmentManager.beginTransaction().replace()(
//                R.id
//            )

//            val bundle = Bundle()
//            bundle.putString("title", title)
//            bundle.putInt("price", price.toInt())
//            bundle.putString("canProposal", canProposal)
//            bundle.putInt("categoryId", categoryId)
//            bundle.putInt("sellerId", userIdx)
//            bundle.putString("imageUrl", "test")
//            bundle.putString("contents", contents)
//
//            val homeFragment = HomeFragment()
//            homeFragment.arguments = bundle
//
//
////            val transaction = supportFragmentManager.beginTransaction()
////            transaction.add(R.id.frameLayout, fragmentA)
////            transaction.commit()
//
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.add(R.id.main_frm, homeFragment)
//            transaction.commit()


        }

        binding.productWriteImgBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

//            val p=PopupMenu(applicationContext, binding.productWriteClCate)
//            menuInflater.inflate(R.menu.menu_edit_product_category,
//                p.menu)
//            p.show()

    }

    fun showDialog() {
        val write_cate = resources.getStringArray(R.array.write_cate)

        val builder = AlertDialog.Builder(this)
        builder.setItems(write_cate, DialogInterface.OnClickListener { dialog, which ->
            binding.productWriteTxtCate.text = write_cate[which].toString()
            categoryId = which + 2
            Log.e("categoryId", categoryId.toString())
        })
        var alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    override fun onPostProductWritingSuccess(response: ResponseWriting) {
//        dismissLoadingDialog()
        intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
        finish()
//        title = title,
//        price = price.toInt(),
//        canProposal = canProposal,
//        categoryId = categoryId,
//        sellerId = userIdx,
//        imageUrl = "test",
//        contents = contents


//        val bundle = Bundle()
//        bundle.putInt("productIdx", response.result.productIdx)
//
//        val homeFragment = HomeFragment()
//        homeFragment.arguments = bundle
//
//
////            val transaction = supportFragmentManager.beginTransaction()
////            transaction.add(R.id.frameLayout, fragmentA)
////            transaction.commit()
//
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.main_frm, homeFragment)
//        transaction.commit()


    }

    override fun onPostProductWritingFailure(message: String) {
    }


//    override fun onCreateContextMenu(
//        menu: ContextMenu?,
//        v: View?,
//        menuInfo: ContextMenu.ContextMenuInfo?,
//    ) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//            menuInflater.inflate(R.menu.menu_product_write_category, menu)
//
//    }
//
//    override fun onContextItemSelected(item: MenuItem): Boolean {
//
//        when(item?.itemId){
//            R.id.home_category_digital -> binding.productWriteTxtCate.text="hi"
//        }
//
//        return super.onContextItemSelected(item)
//
//    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.data != null) {
            val selectedImageUri = data.data
            binding.x.visibility=View.VISIBLE
            binding.productImg.visibility = View.VISIBLE
            binding.productImg.setImageURI(selectedImageUri)
            binding.productImg.background = resources.getDrawable(R.drawable.image_rounding)
            binding.productImg.clipToOutline = true
            uri = selectedImageUri
            binding.productWriteTxtNow.text="1"
//            binding.productWriteTxtNow.setTextColor(Color.parseColor("FFee8548"))

        }
        super.onActivityResult(requestCode, resultCode, data)
    }


    private fun checkPermissions() {
        //거절되었거나 아직 수락하지 않은 권한(퍼미션)을 저장할 문자열 배열 리스트
        var rejectedPermissionList = ArrayList<String>()

        //필요한 퍼미션들을 하나씩 끄집어내서 현재 권한을 받았는지 체크
        for (permission in requiredPermissions) {
            if (ContextCompat.checkSelfPermission(this,
                    permission) != PackageManager.PERMISSION_GRANTED
            ) {
                //만약 권한이 없다면 rejectedPermissionList에 추가
                rejectedPermissionList.add(permission)
            }
        }
        //거절된 퍼미션이 있다면...
        if (rejectedPermissionList.isNotEmpty()) {
            //권한 요청!
            val array = arrayOfNulls<String>(rejectedPermissionList.size)
            ActivityCompat.requestPermissions(this,
                rejectedPermissionList.toArray(array),
                multiplePermissionsCode)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            multiplePermissionsCode -> {
                if (grantResults.isNotEmpty()) {
                    for ((i, permission) in permissions.withIndex()) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
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

}