package com.dreamers.shiweitian.Report_page;

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
import com.dreamers.shiweitian.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/1/9.
 */

public class Report_product extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter_nearby listViewAdapter;
    private List<Map<String, Object>> listItems;
    private String[] title1 = {"德芙榛仁葡萄干巧克力", "费列罗榛果威化巧克力","M&M's花生牛奶巧克力"};
    private String[] title2 = {"爱芬食品（北京）有限公司",
            "费列罗贸易（上海）有限公司",
            "玛氏食品（中国）有限公司"};
    private Integer[] imgeIDs = {R.drawable.chocolate1,
            R.drawable.chocolate2, R.drawable.chocolate3,
            R.drawable.chocolate4, R.drawable.chocolate5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_product);

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
        actionBar.setTitle("             举报产品");

        listView = (ListView)this.findViewById(R.id.listView1);
        listItems = getListItems();
        listViewAdapter = new ListViewAdapter_nearby(this, listItems); //创建适配器
        listView.setAdapter(listViewAdapter);
        setListViewHeightBasedOnChildren(listView);
        listView.setFocusable(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it =new Intent();
                it.setClass(Report_product.this, Report_product_detail.class);
                it.putExtra("name",listItems.get(position).get("title1").toString() );//给intent添加额外数据，key为“str”,key值为"Intent Demo"
                it.putExtra("address",listItems.get(position).get("title2").toString() );
                startActivity(it);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Report_product.this.finish();
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
            map.put("image", imgeIDs[i]);
            map.put("title1", title1[i]);               //图片资源
            map.put("title2", title2[i]);              //物品标题
           // map.put("title3", title3[i]);                 //物品名称
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

