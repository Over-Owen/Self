package com.overz.nativedatasave.javaTest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.overz.nativedatasave.R;

public class JavaTestActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_test);
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        //参数        (Context，数据库名称)
        //数据库名称如果只有名称没有路径，就是在私有目录中
        //如果带路径，数据库位置则在指定的路径中
        String path = Environment.getExternalStorageDirectory() + "stu.db";
        SQLiteOpenHelper helper = new SQLiteOpenHelper(this, path, null,1) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                //创建
                Toast.makeText(JavaTestActivity.this, "数据库创建", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                //升级
                Toast.makeText(JavaTestActivity.this, "数据库升级", Toast.LENGTH_SHORT).show();
            }
        };
    }
}