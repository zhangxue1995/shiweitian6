package com.dreamers.shiweitian.Search_page;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.MyImageView_1;
import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.Report_page.Report_merchant_detail;

/**
 * Created by stzha on 2017/2/14.
 */

public class ShopFragment_detail  extends AppCompatActivity {

    private TextView month1,month2,month3,month4,month5,month6;
    private MyImageView_1 photo;
    private TextView name,canteen_name,canteen_address,canteen_scope,name1;
    private ImageView certificate1,certificate2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopfragment_detail);

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
        actionBar.setTitle("                 详情");

        Intent intent = getIntent();
        String name0 = intent.getStringExtra("name");
        String address0 = intent.getStringExtra("address");

        photo=(MyImageView_1)this.findViewById(R.id.img);
        name=(TextView)this.findViewById(R.id.name);
        canteen_name=(TextView)this.findViewById(R.id.canteen_name);
        canteen_address=(TextView)this.findViewById(R.id.canteen_address);
        canteen_scope=(TextView)this.findViewById(R.id.canteen_scope);
        name1=(TextView)this.findViewById(R.id.name1);
        certificate1=(ImageView)this.findViewById(R.id.certificate1);
        certificate2=(ImageView)this.findViewById(R.id.certificate2);

        name.setText(name0);
        canteen_name.setText(name0);
        name1.setText(name0);
        canteen_address.setText(address0);

        if(name.getText().equals("歪卖厨房")){
            canteen_scope.setText("西式餐饮");
            certificate1.setImageResource(R.drawable.waimaichufang1);
            certificate2.setImageResource(R.drawable.waimaichufang2);
        }
        if(name.getText().equals("澳克士欢乐餐厅&送进宿舍")){
            canteen_scope.setText("西式餐饮,美食小吃");
            certificate1.setImageResource(R.drawable.aokeshi1);
            certificate2.setImageResource(R.drawable.aokeshi2);
        }
        if(name.getText().equals("十里香手撕鸭")){
            canteen_scope.setText("中式餐饮,盖浇饭系列");
            certificate1.setImageResource(R.drawable.shousiya1);
            certificate2.setImageResource(R.drawable.shousiya2);
        }
        if(name.getText().equals("福宇记黄焖鸡米饭")){
            canteen_scope.setText("中式餐饮");
            certificate1.setImageResource(R.drawable.huangmenji1);
            certificate2.setImageResource(R.drawable.huangmenji2);
        }
        if(name.getText().equals("美粥柒天海鲜粥馆（海岸城旗舰店）")){
            canteen_scope.setText("中式餐饮,冷菜、点心");
            certificate1.setImageResource(R.drawable.haixianzhou1);
            certificate2.setImageResource(R.drawable.haixianzhou2);
        }



        Time time = new Time("GMT+8");
        time.setToNow();
        int month = time.month;
        month1=(TextView)this.findViewById(R.id.month1);
        month2=(TextView)this.findViewById(R.id.month2);
        month3=(TextView)this.findViewById(R.id.month3);
        month4=(TextView)this.findViewById(R.id.month4);
        month5=(TextView)this.findViewById(R.id.month5);
        month6=(TextView)this.findViewById(R.id.month6);
        month6.setText(Integer.toString(time.month)+"月");
        month5.setText(Integer.toString(time.month-1<=0?time.month-1+12:time.month-1)+"月");
        month4.setText(Integer.toString(time.month-2<=0?time.month-2+12:time.month-2)+"月");
        month3.setText(Integer.toString(time.month-3<=0?time.month-3+12:time.month-3)+"月");
        month2.setText(Integer.toString(time.month-4<=0?time.month-4+12:time.month-4)+"月");
        month1.setText(Integer.toString(time.month-5<=0?time.month-5+12:time.month-5)+"月");



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ShopFragment_detail.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

