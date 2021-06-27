package com.overz.nativedatasave.sharedPreferancesView

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.overz.nativedatasave.R
import kotlinx.android.synthetic.main.activity_shared_pres.*

class SharedPresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pres)

        /**
         *
         * SharedPreferences 写入
         *
         *
         */
        login_submit.setOnClickListener() {
            //1、获取两个输入框的内容
            //2、验证
            //2.1 存储到sharedPreferences中
            //2.2 验证失败 给用户提示
            val account = account_input.text.toString()
            val password = password_input.text.toString()
            val isCheckedInfo = remmber_account.isChecked
            if (account == "666666" && password == "123456") {
                Toast.makeText(this, "输入正确，等待存储", Toast.LENGTH_SHORT).show()
                //1、获取SharedPreferences对象（参数1:表名 , 参数2:表读写模式）
                val share = getSharedPreferences("login_info", Context.MODE_PRIVATE)
                //2、获取Editor对象  编辑器
                val dataEdit = share.edit()
                //3、存储信息
                dataEdit.putString("account", account)
                dataEdit.putString("password", password)
                dataEdit.putBoolean("isCheckedInfo", isCheckedInfo)
                //4、执行提交
                dataEdit.apply()
                Toast.makeText(this, "存储成功", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "用户名或密码有误", Toast.LENGTH_LONG).show()
            }


        }

        /**
         *
         * SharedPreferences 读取
         *
         *
         *
         */

        val share = getSharedPreferences("login_info", Context.MODE_PRIVATE)
        //参数1：key，参数2：当key不存在时，返回的默认值
        val isCheckedInfo = share.getBoolean("isCheckedInfo", false)
        if (isCheckedInfo) {
            val accountGet = share.getString("account", null)
            val passwordGet = share.getString("password", null)
            val isChecked = share.getBoolean("isChecked",false)
            account_input.setText(accountGet)
            password_input.setText(passwordGet)
            remmber_account.isChecked = true


        }

    }
}