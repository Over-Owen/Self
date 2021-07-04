package com.overz.listview.arrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.overz.listview.R;

/**
 * 1.准备布局（每一项的显示效果）
 * 2.准备数据源
 * 3.实例化适配器
 * 4.设置适配器
 */
public class ArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        //找到listView控件
        ListView listView1 = findViewById(R.id.listView1);

        //2.准备数据源
        String[] data = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};

        //3.实例化适配器
        //参数1：上下文this，参数2：每一项数据所显示的布局形态，参数3：数据源object
        ArrayAdapter adapter1 = new ArrayAdapter(this, R.layout.item, R.id.text_view, data);

        //4.设置适配器
        listView1.setAdapter(adapter1);
    }

}