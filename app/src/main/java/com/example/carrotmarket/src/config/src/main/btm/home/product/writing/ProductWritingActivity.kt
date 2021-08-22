package com.example.carrotmarket.src.config.src.main.btm.home.product.writing

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProductWritingBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.config.src.main.btm.LifeFragment
import com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models.RequestPostWriting
import com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models.ResponseWriting
import com.example.carrotmarket.src.login.LoginService
import com.example.carrotmarket.src.login.models.PostLoginRequest
import com.google.gson.annotations.SerializedName

class ProductWritingActivity :
    BaseActivity<ActivityProductWritingBinding>(ActivityProductWritingBinding::inflate),
    ProductWritingActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//
//        val phoneNumber = binding.loginMainEdtId.text.toString()
//        val password = binding.loginMainEdtPwd.text.toString()
//
//        val postRequest = PostLoginRequest(
//            phoneNumber = phoneNumber,
//            password = password
//        )
//        LoginService(this).tryPostLogin(postRequest)


//        val title:String,
//        @SerializedName("description") val contents: String,
//        val price:Int,
//        val canProposal:String,
//        val categoryId:Int,
//        val sellerId:Int,
//        val imageUrl:String




        binding.productWriteComp.setOnClickListener {
            val title = binding.productWriteTitle.text.toString()
            val price = binding.productWritePrice.text.toString()
            val contents = binding.productWriteContents.text.toString()

            val requestPostWriting = RequestPostWriting(
                title=title,
                price=price.toInt(),
                canProposal="Y",
                categoryId=1,
                sellerId=1,
                imageUrl="test",
                contents = contents
            )
            ProductWritingService(this).tryPostProductWriting(requestPostWriting)
        }

        binding.productWriteImgBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.productWriteClCate.setOnClickListener {
//            showDialog()
            val categoryId =0
            val write_cate = resources.getStringArray(R.array.write_cate)

            val builder = AlertDialog.Builder(this)
            builder.setItems(write_cate, DialogInterface.OnClickListener { dialog, which ->
                binding.productWriteTxtCate.text = write_cate[which].toString()
                for (i in 2..write_cate.size){
                    write_cate[i-2]
                }
            })
            var alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }


//
//
//
//        )


//            val p=PopupMenu(applicationContext, binding.productWriteClCate)
//            menuInflater.inflate(R.menu.menu_product_write_category,
//                p.menu)
//            p.show()

    }

    fun showDialog() {

    }

    override fun onPostProductWritingSuccess(response: ResponseWriting) {

        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
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

}