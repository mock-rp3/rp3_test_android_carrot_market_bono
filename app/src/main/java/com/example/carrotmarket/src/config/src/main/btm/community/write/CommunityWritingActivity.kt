package com.example.carrotmarket.src.config.src.main.btm.community.write

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityCommunityWritingBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.config.src.main.btm.community.write.models.CWritingRequest
import com.example.carrotmarket.src.config.src.main.btm.community.write.models.CWritingResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.ProductWritingService
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.RequestPostWriting

class CommunityWritingActivity:BaseActivity<ActivityCommunityWritingBinding>(ActivityCommunityWritingBinding::inflate),
CommunityWritingActivityView{

    private var categoryId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.local.text =
            Html.fromHtml("<u>" +binding.local.text + "</u>")
        binding.productWriteClCate.setOnClickListener {
            showDialog()
            binding.certLl.visibility= View.GONE
        }

        //    val description:String,
        //    val categoryId:Int,
        //    val regionId:Int,
        //    val userInfoId:Int
        // userIdx 가져오기
        ApplicationClass.sSharedPreferences =
            getSharedPreferences("userIdx", AppCompatActivity.MODE_PRIVATE)

        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0)
        Log.e("userIdx2", userIdx.toString())

        binding.communityWriteComp.setOnClickListener {
            val description=binding.communityWriteContents.text.toString()
            val cWritingRequest = CWritingRequest(
                description = description,
                categoryId = categoryId,
                regionId = 3,
                userInfoId = 2 // 유저 인포 아이디가 2여야지만 화면에 표시되서 임의로 지정해둠

            )
            CommunityWritingService(this).tryPostCommunityWriting(cWritingRequest)
        }

    }
    fun showDialog() {
        val write_cate2 = resources.getStringArray(R.array.write_cate2)

        val builder = AlertDialog.Builder(this)
        builder.setItems(write_cate2, DialogInterface.OnClickListener { dialog, which ->
            binding.productWriteTxtCate.text = write_cate2[which].toString()
            categoryId = which + 2
            Log.e("categoryId", write_cate2.toString())
        })
        var alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
    override fun onPostCommunityWritingSuccess(response: CWritingResponse) {
        intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }

    override fun onPostCommunityWritingFailure(message: String) {
    }
}