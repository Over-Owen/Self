package com.overz.nativedatasave.externalSave

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.overz.nativedatasave.R
import kotlinx.android.synthetic.main.activity_external_save.*
import java.io.*


class ExternalSaveActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_save)

        //检查是否拥有权限，此处使用的是写入外部存储的权限
        val permission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        //判断权限是有给与
        if (permission != PackageManager.PERMISSION_GRANTED) {
            //动态去申请权限
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ),     //可能会有多项权限，用数组的方式申请多个权限
                123
            )
            Log.e("权限", "已申请")
        }

        text_save.setOnClickListener() {
            saveText()
        }
        text_read.setOnClickListener() {
            readText()
        }

        text_save_public.setOnClickListener() {
            saveTextPublic()
        }
        text_read_public.setOnClickListener() {
            readTextPublic()
        }


        clean_text.setOnClickListener() {
            input_text.setText("")
        }
    }


    //可以通过请求码在回去请求的时候做一些其他的操作
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //如下
        if (requestCode == 123) {
            //TODO()
        }
        if (requestCode == 456) {
            //TODO()
        }
    }

    //写入文本  /Android/data/com.overz.nativedatasave/files/OverZ.txt
    private fun saveText() {
        val filePath = getExternalFilesDir(null)?.absolutePath + File.separator + "OverZ.txt"
        Log.e("文件路径", filePath)
        File(filePath).appendText((input_text.text.toString()))
        input_text.setText("")
    }

    //读取文本  /Android/data/com.overz.nativedatasave/files/OverZ.txt
    private fun readText() {
        val filePath = getExternalFilesDir(null)?.absolutePath + File.separator + "OverZ.txt"
        val file = File(filePath)
            //文件不存在
            if (!file.exists()) {
                Toast.makeText(this, "文件不存在！", Toast.LENGTH_SHORT).show()
            }
            else{
                val text = File(filePath).readText()
                input_text.setText(text)
            }

    }

    /**
     * 在 Android 10 之前都有效，Android 11 后无效
     */
    //写入文本      0/Documents/OverZ.txt
    private fun saveTextPublic() {
//                //判断内存卡是否存在，可以写在所有操作之前，包含
//        if (Environment.getExternalStorageState() == "mounted"){
//
//        }
//        val path = getExternalFilesDir(null)?.absolutePath + File.separator + "OverZ.txt"
        val path = Environment.getExternalStorageDirectory().absolutePath + "/overz.txt"
        Log.e("路径", path)
        val file = File(path)
        try {
            //文件不存在，则穿件新的文件
            if (!file.exists()) {
                file.createNewFile()
            }
            //传入文件路径， 是否追加
            val fileOutputStream = FileOutputStream(path, true)
            val str = input_text.text.toString()
            fileOutputStream.write(str.toByteArray())
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
    }

    //读取文本      0/Documents/OverZ.txt
    private fun readTextPublic() {
//        val path = getExternalFilesDir(null)?.absolutePath + File.separator + "OverZ.txt"
        val path = Environment.getExternalStorageDirectory().absolutePath + "/overz.txt"
        Log.e("路径", path)
        val file = File(path)
        try {
            val fileInputStream = FileInputStream(path)
            val byteArray = ByteArray(1024)
            val len: Int = fileInputStream.read(byteArray)
            fileInputStream.read(byteArray)
            val str = String(byteArray, 0, len)
            input_text.setText(str)
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        } catch (fnf: FileNotFoundException) {
            fnf.printStackTrace()
        }
    }

}
