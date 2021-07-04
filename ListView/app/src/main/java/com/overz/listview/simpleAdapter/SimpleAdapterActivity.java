package com.overz.listview.simpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.overz.listview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {
    private List<Map<String,Object>> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        //1.获取ListView对象
        ListView listView2 = findViewById(R.id.listView2);

        //2.实例化适配器对象

        //参数1：上下文，
        // 参数2：数据，
        initData();
        // 参数3：布局形态资源,
        // 参数4：data资源文件的map中的名称，
        String[] from = {"img","name","quote"};
        // 参数5：xml布局文件中的id名称
        //一一对应
        int[] to = {R.id.iamge1,R.id.name1,R.id.quote1};
        SimpleAdapter adapter2 = new SimpleAdapter(this, data, R.layout.item2, from, to);

        //3.为ListView设置适配器
        listView2.setAdapter(adapter2);


        /**
         * item点击事件
         * setOnItemClickListener
         */
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //view 所点击的哪一项的视图
            //position 当前选中的视图的索引！！！！ 可以拿到数据源索引的所有信息
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map = data.get(position);
                String name = map.get("name").toString();
                String quote = map.get("quote").toString();
                Log.d("名字",name);
                Log.d("名言",quote);
            }
        });
    }

    private void initData() {
        //数据的结构
        //左边头像，右上名字，右下语录
        Map<String,Object> map1 = new HashMap<>();
        map1.put("img",R.mipmap.ic_launcher_round);
        map1.put("name","小明");
        map1.put("quote","hahahahahahahahaha");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("img",R.mipmap.ic_launcher_round);
        map2.put("name","小花");
        map2.put("quote","hahahahahahahahaha");

        Map<String,Object> map3 = new HashMap<>();
        map3.put("img",R.mipmap.ic_launcher_round);
        map3.put("name","小芳");
        map3.put("quote","hahahahahahahahaha");

        Map<String,Object> map4 = new HashMap<>();
        map4.put("img",R.mipmap.ic_launcher_round);
        map4.put("name","小晴");
        map4.put("quote","hahahahahahahahaha");

        Map<String,Object> map5 = new HashMap<>();
        map5.put("img",R.mipmap.ic_launcher_round);
        map5.put("name","小丽");
        map5.put("quote","hahahahahahahahaha");
        Map<String,Object> map6 = new HashMap<>();
        map6.put("img",R.mipmap.ic_launcher_round);
        map6.put("name","小芳");
        map6.put("quote","hahahahahahahahaha");

        Map<String,Object> map7 = new HashMap<>();
        map7.put("img",R.mipmap.ic_launcher_round);
        map7.put("name","小晴");
        map7.put("quote","hahahahahahahahaha");

        Map<String,Object> map8 = new HashMap<>();
        map8.put("img",R.mipmap.ic_launcher_round);
        map8.put("name","小丽");
        map8.put("quote","hahahahahahahahaha");

        data.add(map1);
        data.add(map2);
        data.add(map3);
        data.add(map4);
        data.add(map5);
        data.add(map6);
        data.add(map7);
        data.add(map8);

    }
}