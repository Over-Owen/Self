package com.overz.nativedatasave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.overz.nativedatasave.sharedPreferancesView.SharedPresActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPrefers.setOnClickListener(){
            val intent = Intent(this, SharedPresActivity::class.java)
            startActivity(intent)
        }
    }
}
