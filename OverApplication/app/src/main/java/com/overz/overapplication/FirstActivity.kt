package com.overz.overapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first.*


class FirstActivity : AppCompatActivity() {

    /**
     * Activity创建时，生成布局 - 类.
     * <p>
     * 重写方法，初始化页面布局，按钮跳转功能设计
     * </p>
     * @param savedInstanceState Bundle，保存页面状态
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        //为button1，设置点击事件监听         点击关闭Activity
        button1.setOnClickListener {
            //点击事件内容
            Toast.makeText(this, "退出FirstActivity", Toast.LENGTH_SHORT).show()
            finish()
        }

        //为button3，设置点击事件监听         点击显式跳转SecondActivity
        button2.setOnClickListener {
            //点击事件内容
            Toast.makeText(this, "显式跳转到SecondActivity", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        //为button3，设置点击事件监听        点击隐式跳转SecondActivity
        button3.setOnClickListener {
            //点击事件内容
            Toast.makeText(this, "隐式跳转到SecondActivity", Toast.LENGTH_SHORT).show()
            val intent = Intent("com.overz.overapplication.ACTION_happy")
            //自定义添加的一个Category，不添加就按照相应跳转页面的AndroidManifest.xml中的默认的Category
            intent.addCategory("com.overzapplication.Happy_Category")
            startActivity(intent)
        }

        //为button4，设置点击事件监听        点击隐式跳转到其他应用程序的Activity
        button4.setOnClickListener {
            //点击事件内容
            Toast.makeText(this, "隐式跳转到其他应用程序的Activity", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW)
            //跳转到系统默认浏览器，并打开地址
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }

        //为button5，设置点击事件监听        点击隐式跳转到其他应用程序的Activity
        button5.setOnClickListener {
            //点击事件内容
            Toast.makeText(this, "隐式跳转到其他应用程序的Activity", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            //跳转到系统默认浏览器，并打开地址
            intent.data = Uri.parse("tel:10010")
            startActivity(intent)
        }

        //为button6，设置点击事件监听        点击显式跳转到下一个Activity，并传递数据
        button6.setOnClickListener {
            //点击事件内容
            Toast.makeText(this, "跳转到下一个Activity，并传递数据", Toast.LENGTH_SHORT).show()
            val data = "Hello Next Activity."
            val intent = Intent(this, DeliverActivity::class.java)
            //括号中的 name: "extra_data" 要与上一个Activity中参数名相同
            intent.putExtra("extra_data", data)
            startActivity(intent)
        }

        //为button7，设置点击事件监听        点击显式跳转到下一个Activity，s使返回时，传回返回值
        button7.setOnClickListener {
            //点击事件内容
            Toast.makeText(this, "跳转到下一个Activity", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ResultBackActivity::class.java)
            //使用startActivityForResult方法启动下一个Activity，期望在Activity销毁时，返回一个结果给上一个Activity
            //第一个灿叔叔intent，第二个参数是请求码
            startActivityForResult(intent, 111)
        }

    }

    /**
     * 创建选择菜单 - 方法.
     * <p>
     * 重写方法，通过布局id获取菜单的布局文件，此处选择的是 main.xml
     * </p>
     * @param menu Menu，传入的菜单
     *
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuInflater类 实例化xml菜单文件为Menu对象。
        //inflate方法 从指定的 XML 资源扩充菜单层次结构。
        menuInflater.inflate(R.menu.main, menu)
        return true                 //返回值为true菜单显示，false菜单不显示
    }

    /**
     * 当菜单中的选项被选中(点击)时的操作 - 方法.
     * <p>
     * 重写方法，获取裁断选项的点击事件，使用when判断不同item的操作
     * </p>
     * @param item MenuItem，
     *
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //通过when判断 selected点击不同的选项，进行不同的操作
        when (item.itemId) {
            //此处为菜单文件xml的 item选项 的itemId判断
            R.id.add_item -> Toast.makeText(this, "添加...", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "删除...", Toast.LENGTH_SHORT).show()
            R.id.other_item -> Toast.makeText(this, "其他...", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)        //返回boolean类型，但目前操作返回true和false，效果相同
    }

    /**
     * 获取从其他页面 返回的数据 - 方法.
     * <p>
     * 其他页面点击返回键或者按钮返回到本页，会通过本方法，返回一个值
     * </p>
     * @param requestCode Int，startActivityForResult方法定义的请求码，用于匹配页面
     * @param resultCode Int，与之前返回的页面确认返回结果码
     * @param data，Intent，意图对象，其中包含返回的值(字符串)
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //根据requestCode返回码，对应本页的requestCode，以及判断resultCode
        //通过requestCode,选择不同页面的返回值
        when (requestCode) {
            111 -> if (resultCode == RESULT_OK) {      //RESULT_OK = -1
                //getStringExtra通过data对象，获取参数名为data_return的返回值，与返回页相同
                val returnData = data?.getStringExtra("data_return")
                Toast.makeText(this, "返回的数据：$returnData", Toast.LENGTH_SHORT).show()
            }
        }
    }

}