package com.overz.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.overz.listview.arrayAdapter.ArrayAdapterActivity;
import com.overz.listview.baseAdapter.BaseAdapterActivity;
import com.overz.listview.simpleAdapter.SimpleAdapterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button arrayAdapterBtn = findViewById(R.id.array_adapter_btn);
        arrayAdapterBtn.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ArrayAdapterActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,
                    "跳转ArrayAdapterActivity", Toast.LENGTH_SHORT).show();
        });
        Button simpleAdapterBtn = findViewById(R.id.simple_adapter_btn);
        simpleAdapterBtn.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SimpleAdapterActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,
                    "跳转SimpleAdapterActivity", Toast.LENGTH_SHORT).show();
        });
        Button baseAdapterBtn = findViewById(R.id.base_adapter_btn);
        baseAdapterBtn.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, BaseAdapterActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,
                    "跳转BaseAdapterActivity", Toast.LENGTH_SHORT).show();
        });


    }
}