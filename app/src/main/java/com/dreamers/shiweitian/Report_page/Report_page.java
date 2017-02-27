package com.dreamers.shiweitian.Report_page;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.MainActivity;
import com.dreamers.shiweitian.Home_page.MyGridView;
import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.News_page.News_page;
import com.dreamers.shiweitian.Personal_information;
import com.dreamers.shiweitian.QandA_page.QandA_page;
import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.Search_page.Search_page;
import com.dreamers.shiweitian.User;
import com.dreamers.shiweitian.zxing.QR_report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/1/8.
 */

public class Report_page extends AppCompatActivity implements View.OnClickListener {
    private TextView tab1;
    private TextView tab2;
    private TextView tab3;
    private TextView tab4;
    private TextView tab5;

    private ImageView report_merchant,report_product;
    private ImageView qr_code,phone;
private android.support.v7.app.ActionBar actionBar;
    private ListView listView;
    private ListViewAdapter_report listViewAdapter;
    private List<Map<String, Object>> listItems;
    private String[] title1 = {"德芙榛仁葡萄干巧克力", "费列罗榛果威化巧克力","M&M's花生牛奶巧克力"};
    private String[] title2 = {"2015年5月31日",
            "2015年5月31日",
            "2015年5月31日"};
    private String[] title3 = {"爱芬食品（北京）有限公司",
            "费列罗贸易（上海）有限公司",
            "玛氏食品（中国）有限公司"};
    private Integer[] imgeIDs = {R.drawable.chocolate1,
            R.drawable.chocolate2, R.drawable.chocolate3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#FF4CAF50"));//设置状态栏颜色

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.user_photo);
        actionBar.setTitle("请登录");

        User user=(User)getApplication();
        if(user.isLogin()==true) {
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            actionBar.setTitle(name);
        }


        //底部导航栏
        tab1 = (TextView) this.findViewById(R.id.txt_1);
        tab2 = (TextView) this.findViewById(R.id.txt_2);
        tab3 = (TextView) this.findViewById(R.id.txt_3);
        tab4 = (TextView) this.findViewById(R.id.txt_4);
        tab5 = (TextView) this.findViewById(R.id.txt_5);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);
        tab5.setOnClickListener(this);
        tab3.setSelected(true);

        report_merchant=(ImageView)this.findViewById(R.id.report_merchant);
        report_product=(ImageView)this.findViewById(R.id.report_product);
        report_merchant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent();
                it.setClass(Report_page.this, Report_merchant.class);
                startActivity(it);
            }
        });
        report_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent();
                it.setClass(Report_page.this, Report_product.class);
                startActivity(it);
            }
        });

        qr_code=(ImageView)this.findViewById(R.id.qr_code);
        phone=(ImageView)this.findViewById(R.id.phone);
        qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent();
                it.setClass(Report_page.this, QR_report.class);
                startActivity(it);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + "(0510)82702731");
                intent.setData(data);
                startActivity(intent);
            }
        });

        listView = (ListView)this.findViewById(R.id.list1);
        listItems = getListItems();
        listViewAdapter = new ListViewAdapter_report(this, listItems); //创建适配器
        listView.setAdapter(listViewAdapter);
        setListViewHeightBasedOnChildren(listView);
        listView.setFocusable(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it =new Intent();
                it.setClass(Report_page.this, Report_product_detail.class);
                it.putExtra("name",listItems.get(position).get("title1").toString() );//给intent添加额外数据，key为“str”,key值为"Intent Demo"
                it.putExtra("address",title3[position] );
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent it =new Intent();
                it.setClass(Report_page.this, Personal_information.class);
                startActivityForResult(it,4);
                //    MainActivity.this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //重置所有文本的选中状态
    public void selected(){
        tab1.setSelected(false);
        tab2.setSelected(false);
        tab3.setSelected(false);
        tab4.setSelected(false);
        tab5.setSelected(false);
    }
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.txt_1:
                selected();
                tab1.setSelected(true);
                Intent it1 =new Intent();
                it1.setClass(Report_page.this, MainActivity.class);
                it1.putExtra("name",actionBar.getTitle().toString());
                startActivity(it1);
                Report_page.this.finish();
                break;

            case R.id.txt_2:
                selected();
                tab2.setSelected(true);
                Intent it2 =new Intent();
                it2.setClass(Report_page.this, News_page.class);
                it2.putExtra("name",actionBar.getTitle().toString());
                startActivity(it2);
                Report_page.this.finish();
                break;

            case R.id.txt_3:
                selected();
                tab3.setSelected(true);
                break;

            case R.id.txt_4:
                selected();
                tab4.setSelected(true);
                Intent it4 =new Intent();
                it4.setClass(Report_page.this, QandA_page.class);
                it4.putExtra("name",actionBar.getTitle().toString());
                startActivity(it4);
                Report_page.this.finish();
                break;

            case R.id.txt_5:
                selected();
                tab5.setSelected(true);
                Intent it5 =new Intent();
                it5.setClass(Report_page.this, Search_page.class);
                it5.putExtra("name",actionBar.getTitle().toString());
                startActivity(it5);
                Report_page.this.finish();
                break;
        }

//        transaction.commit();
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 0) {  //返回成功
            switch (requestCode) {
                case 4: {//从Personal_information返回

                    Intent intent = getIntent();
                    //从Intent当中根据key取得value
                    Bundle bundle2 = data.getBundleExtra("bundle2");
                    final String name = bundle2.getString("strResult");
                    actionBar.setTitle(name);
                    break;
                }
            }
        }
    }

}
