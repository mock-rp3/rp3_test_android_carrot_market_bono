package com.example.carrotmarket.src.config.src.product

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProductWriteBinding

class ProductWriteActivity :
    BaseActivity<ActivityProductWriteBinding>(ActivityProductWriteBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.productWriteClCate.setOnClickListener {
            val p=PopupMenu(applicationContext, binding.productWriteClCate)
            menuInflater.inflate(R.menu.menu_product_write_category,
                p.menu)
            p.show()
        }

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