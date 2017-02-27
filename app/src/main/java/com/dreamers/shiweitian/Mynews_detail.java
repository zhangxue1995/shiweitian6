package com.dreamers.shiweitian;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.News_page.News_detail;
import com.dreamers.shiweitian.Report_page.ListViewAdapter_myreport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/2/26.
 */

public class Mynews_detail extends AppCompatActivity {

    private TextView title,content,time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mynews_detail);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#FF4CAF50"));//设置状态栏颜色

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("             我的消息");

        Intent intent = getIntent();
        String title0 = intent.getStringExtra("title");
        String content0 = intent.getStringExtra("content");
        String time0 = intent.getStringExtra("time");

        title=(TextView)this.findViewById(R.id.title1);
        time=(TextView)this.findViewById(R.id.title2);
        content=(TextView)this.findViewById(R.id.title3);

        title.setText(title0);
        time.setText(time0);
        content.setText(content0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Mynews_detail.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
