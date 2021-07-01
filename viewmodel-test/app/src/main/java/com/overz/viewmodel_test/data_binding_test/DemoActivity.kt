package com.overz.viewmodel_test.data_binding_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.overz.viewmodel_test.R
import com.overz.viewmodel_test.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {

    private lateinit var account: Account

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

//        DataBindingUtil.setContentView<ActivityDemoBinding>(this,R.layout.activity_main)

        var binding: ActivityDemoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_demo)

        account = Account("Tom",1)
        binding.account = account
    }
}