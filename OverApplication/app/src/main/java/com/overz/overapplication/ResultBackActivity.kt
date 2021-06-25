package com.overz.overapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import kotlinx.android.synthetic.main.activity_result_back.*

class ResultBackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_back)
        //设置点击事件返回"Hello FirstActivity"字符串，销毁进程
        btn4.setOnClickListener {
            goBackReturnData()
        }
    }

    //返回按钮添加页面返回事件
    override fun onBackPressed() {
        goBackReturnData()
    }

    //当点击返回键或者布局中设置的按钮返回功能，返回的数据
    private fun goBackReturnData() {
        //返回"Hello FirstActivity"字符串，销毁进程
        val intent = Intent()
        //传递的数据名为 "data_return"，字符串数据为 "Hello FirstActivity"
        intent.putExtra("data_return", "Hello FirstActivity")
        setResult(RESULT_OK, intent)
        finish()
    }
}