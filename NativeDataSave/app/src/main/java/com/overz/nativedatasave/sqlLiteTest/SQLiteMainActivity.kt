package com.overz.nativedatasave.sqlLiteTest

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.overz.nativedatasave.R
import kotlinx.android.synthetic.main.activity_s_q_lite_main.*

class SQLiteMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_q_lite_main)

        //参数 context 数据库名 版本
        val dbHelper = MyDatabaseHelper(this,"BookStore.db",2)
        create_database.setOnClickListener{
            dbHelper.writableDatabase
        }
        addData.setOnClickListener{
            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply {
                //开始组装第一条数据
                put("name","Kotlin教程")
                put("author","Harden")
                put("price","26.8")
            }
            db.insert("Book",null,values1)
            val values2 = ContentValues().apply {
                //开始组装第一条数据
                put("name","Android教程")
                put("author","James")
                put("price","31.9")
            }
            db.insert("Book",null,values2)
            Toast.makeText(this,"已添加数据",Toast.LENGTH_SHORT).show()
        }

        updateData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price",39.99)
            val name = "Kotlin教程"
            db.update("Book",values,"name = ?", arrayOf(name))
            Toast.makeText(this,"已更新数据",Toast.LENGTH_SHORT).show()
        }

        deleteData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val author = "James"
            db.delete("Book","author = ?", arrayOf(author))
            Toast.makeText(this,"已删除$author",Toast.LENGTH_SHORT).show()
        }
        queryData.setOnClickListener {
            val db = dbHelper.writableDatabase
            //查询Book表中的数据
            val cursor = db.query("Book",null,null,null,null,null,null)
            if (cursor.moveToFirst()) {
                do{
                    //遍历Cursor对象，取出并打印
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val price = cursor.getDouble(cursor.getColumnIndex("price"))
                    Log.d("name", name)
                    Log.d("author", author)
                    Log.d("price","$price")
                }while (cursor.moveToNext())
            }
            cursor.close()
        }
    }
}

class MyDatabaseHelper(val context: Context, name: String, version: Int) : SQLiteOpenHelper(context,name,null,version){
    //创建数据表1 SQL语句
    private val createBook = "create table Book (" +
            " id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "name text)"
    //创建数据表1 SQL语句
    private val createCategory = "create table Category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createBook)
        db?.execSQL(createCategory)
        Log.d("TAG","已创建数据库")
        Toast.makeText(context,"Create succeeded",Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists Book")
        db?.execSQL("drop table if exists Category")
        onCreate(db)
        Log.d("TAG","已更新数据表")
    }
}