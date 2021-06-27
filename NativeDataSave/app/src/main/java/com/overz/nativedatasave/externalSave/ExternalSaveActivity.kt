package com.overz.nativedatasave.externalSave

import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.overz.nativedatasave.R
import kotlinx.android.synthetic.main.activity_external_save.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class ExternalSaveActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_save)
        text_save.setOnClickListener() {
            saveText()
        }
        text_read.setOnClickListener() {
            readText()
        }

    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun saveText() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            //        val path1 = getExternalFilesDir("Over_Z.txt")          //创建的是文件夹？？
//        Log.e("标签", path1.toString())
            val path = Environment.getExternalStorageDirectory().absolutePath + "/Documents/Over_z.txt"
            Log.e("标签", path)
            val file = File(path)
            try {
                if (!file.exists()) {
                    file.createNewFile()
                }
                val fileOutputStream = FileOutputStream(path,true)
                val str  = input_text.text.toString()
                Log.d("字符串",str)
                //toByteArray()   Java方法是getBytes()       一字节流的方式一次存入
                fileOutputStream.write(str.toByteArray())
                //外部存储需要添加权限，读  写 权限
            } catch (ioe: IOException) {
                Log.e("ERROR","写入错误！")
            }

        }


    }

    private fun readText() {
        val path = Environment.getExternalStorageDirectory().absolutePath + "/Documents/Over_z.txt"
        val fileInputStream = FileInputStream(path)
        val byteArray = ByteArray(1024)
        val len: Int = fileInputStream.read(byteArray)
        fileInputStream.read(byteArray)
        val str = String(byteArray,0,len)
        Log.d("标签",str)
        input_text.setText(str)
    }
}