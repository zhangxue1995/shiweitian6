package com.dreamers.shiweitian.Report_page;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/1/9.
 */

public class Submited extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter_myreport listViewAdapter;
    private List<Map<String, Object>> listItems;
    private String[] title1 = {"华莱士（公道店）"};
    private String[] title2 = {"2017年1月19日"};
    private String[] title3 = {"出售过期食品（免费续杯的可乐气不足，怀疑出售过期可乐）"};
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submited);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#FF4CAF50"));//设置状态栏颜色

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("              已提交");


        listView = (ListView)this.findViewById(R.id.list1);
        listItems = getListItems();
        listViewAdapter = new ListViewAdapter_myreport(this, listItems); //创建适配器
        listView.setAdapter(listViewAdapter);

        t=(TextView)this.findViewById(R.id.t);
        if(title1.length==0){
            t.setText("你还没有相关举报");
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it =new Intent();
                it.setClass(Submited.this, Feedback_detail.class);
                it.putExtra("str1","已提交");//给intent添加额外数据，key为“str”,key值为"Intent Demo"
                it.putExtra("str2",listItems.get(position).get("title1").toString() );
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Submited.this.finish(); // back button
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
