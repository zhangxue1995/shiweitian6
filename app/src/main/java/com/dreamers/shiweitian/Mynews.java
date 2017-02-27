package com.dreamers.shiweitian;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.MainActivity;
import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.News_page.News_detail;
import com.dreamers.shiweitian.Report_page.Feedback_detail;
import com.dreamers.shiweitian.Report_page.ListViewAdapter_myreport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/2/26.
 */

public class Mynews extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter_myreport listViewAdapter;
    private List<Map<String, Object>> listItems;
    private String[] title1;
    private String[] title2;
    private String[] title3;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mynews);

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


        title1=new String[]{"系统消息"};
        Time time = new Time("GMT+8");
        time.setToNow();time.month=time.month+1;
        String time0=time.year+"年"+time.month+"月"+time.monthDay+"日";
        title2=new String[]{time0};
        title3=new String[]{"民以食为天，食以安为先。本应用是一款以食品安全问题举报为核心的手机应用，可以在手机上随时随地查询和浏览相关食品安全资讯，并且可以向有关部门举报身边存在的食品安全问题。我们的目标是减少食品安全隐患，还人们健康生活。"};

        listView = (ListView)this.findViewById(R.id.list1);
        listItems = getListItems();
        listViewAdapter = new ListViewAdapter_myreport(this, listItems); //创建适配器
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                it.setClass(Mynews.this, Mynews_detail.class);
                it.putExtra("title", listItems.get(position).get("title1").toString());
                it.putExtra("content",listItems.get(position).get("title3").toString() );
                it.putExtra("time",listItems.get(position).get("title2").toString() );
                startActivity(it);
            }
        });

        t=(TextView)this.findViewById(R.id.t);
        if(title1.length==0){
            t.setText("你还没有相关消息");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Mynews.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * 初始化商品信息
     */
    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < title1.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("title1", title1[i]);               //图片资源
            map.put("title2", title2[i]);              //物品标题
            map.put("title3", title3[i]);     //物品名称
            listItems.add(map);
        }
        return listItems;
    }


}
