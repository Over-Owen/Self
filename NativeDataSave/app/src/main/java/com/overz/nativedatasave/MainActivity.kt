package com.overz.nativedatasave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.overz.nativedatasave.externalSave.ExternalSaveActivity
import com.overz.nativedatasave.sharedPreferancesView.SharedPresActivity
import com.overz.nativedatasave.sqlLiteTest.SQLiteActivity
import com.overz.nativedatasave.sqlLiteTest.SQLiteMainActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPrefers.setOnClickListener() {
            val intent = Intent(this, SharedPresActivity::class.java)
            startActivity(intent)
        }
        externalSave.setOnClickListener() {
            val intent = Intent(this, ExternalSaveActivity::class.java)
            startActivity(intent)
        }
        sqliteSave.setOnClickListener() {
            val intent = Intent(this, SQLiteMainActivity::class.java)
            startActivity(intent)
        }
    }
}
