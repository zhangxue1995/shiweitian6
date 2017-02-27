package com.dreamers.shiweitian.News_page;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.ListViewAdapter;
import com.dreamers.shiweitian.QandA_page.QandA_detail;
import com.dreamers.shiweitian.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/1/8.
 */

public class Healthcolumn_more extends AppCompatActivity{
    private ListView listView;
    private ListViewAdapter_healthcolumn listViewAdapter;
    private List<Map<String, Object>> listItems;
    private String[] title1 = {"健康饮食缓解抑郁",
            "伤肾行为列举 你在日常生活中一定犯过",
            "跟着专家四步走 做一个智慧的看病人",
            "真的有“不少吃不运动还能变瘦”的好方法",
            "手脚麻木可能是8种疾病先兆","不得不看的十部医疗电影 娱乐同时带你涨知识","驴友们请警惕 有种疼痛叫“旅游膝”","年轻人普遍晚睡有哪些心理层面的原因"};
    private String[] title2 = {"人民网",
            "新浪网",
            "新浪网",
            "网易健康",
            "网易专栏","新浪专栏","新浪网","知乎"};
    private Integer[] imgeIDs = {R.drawable.healthcolumn_1,
            R.drawable.healthcolumn_2, R.drawable.healthcolumn_3,
            R.drawable.healthcolumn_4, R.drawable.healthcolumn_5,R.drawable.healthcolumn_6,R.drawable.healthcolumn_7,R.drawable.healthcolumn_8};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthcolumn_more);

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
        actionBar.setTitle("             健康资讯");


        listView = (ListView)findViewById(R.id.list1);
        listItems = getListItems();
        listViewAdapter = new ListViewAdapter_healthcolumn(this, listItems); //创建适配器
        listView.setAdapter(listViewAdapter);
        setListViewHeightBasedOnChildren(listView);
        listView.setFocusable(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it =new Intent();
                it.setClass(Healthcolumn_more.this, News_detail.class);
                it.putExtra("title",listItems.get(position).get("title1").toString() );//给intent添加额外数据，key为“str”,key值为"Intent Demo"
                it.putExtra("source",listItems.get(position).get("title2").toString() );
                startActivity(it);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Healthcolumn_more.this.finish(); // back button
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
            map.put("image", imgeIDs[i]);     //物品名称
            listItems.add(map);
        }
        return listItems;
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
}
