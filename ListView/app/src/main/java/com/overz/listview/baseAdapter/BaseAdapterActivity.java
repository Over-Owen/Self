package com.overz.listview.baseAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.overz.listview.R;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapterActivity extends AppCompatActivity {

    private ListView listView3;
    private ImageView add;
    private List<Msg> list = new ArrayList<>();
    private int[] user_avatar = {R.mipmap.ic_launcher_round, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher};


    //需要传的参数：上下文，数据源
    BaseAdapter adapter4 = new MyBaseAdapter(list, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        listView3 = findViewById(R.id.listView3);
        add = findViewById(R.id.add_btn);

        //数据源
        initData();

        //设置适配器
        listView3.setAdapter(adapter4);

        //add点击事件
        add.setOnClickListener(v -> {
            Msg m = new Msg(R.mipmap.ic_launcher_round, "小明", "2021-07-04", "6666666666666666666！", false);
            list.add(m);
            Toast.makeText(this, "动态添加", Toast.LENGTH_SHORT).show();

            //通知适配器更新数据
            adapter4.notifyDataSetChanged();
            //设置ListView自动显示到最新数据，滚动到最新位置
            listView3.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        });

    }

    private void initData() {
        for (int i = 1; i <= 8; i++) {
            Msg m = new Msg(user_avatar[i - 1], "用户" + i, "2021-07-04", "今天也要加油哦！" + i, i % 2 != 0);
            list.add(m);
        }
    }
}