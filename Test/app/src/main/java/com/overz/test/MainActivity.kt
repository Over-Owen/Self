package com.overz.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit_btn.setOnClickListener {
//            val check = gender_select.checkedRadioButtonId == gender_male.id
//            Log.d("结果", check.toString())
            if (gender_male.isChecked){
//                Log.d("结果", gender_male.isChecked.toString())
                gender_female.isChecked = true
//                gender_female.isChecked
            }else{
//                Log.d("结果", gender_male.isChecked.toString())
                gender_male.isChecked = true
            }

        }

    }
}