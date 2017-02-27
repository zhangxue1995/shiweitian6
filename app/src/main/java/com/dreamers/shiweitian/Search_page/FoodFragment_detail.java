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

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.R;

/**
 * Created by stzha on 2017/2/14.
 */

public class FoodFragment_detail extends AppCompatActivity {

    private ImageView img;
    private TextView name1,address,name2,food_address,standard,card,department,result,name3;
    private TextView nutrition11,nutrition12,nutrition14,nutrition21,nutrition22,nutrition24,nutrition31,nutrition32,nutrition34;
    private ImageView nutrition13,nutrition23,nutrition33;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodfragment_detail);

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



        img=(ImageView)this.findViewById(R.id.img);
        name1=(TextView)this.findViewById(R.id.name1);
        address=(TextView)this.findViewById(R.id.address);
        name2=(TextView)this.findViewById(R.id.name2);
        food_address=(TextView)this.findViewById(R.id.food_address);
        standard=(TextView)this.findViewById(R.id.standard);
        card=(TextView)this.findViewById(R.id.card);
        department=(TextView)this.findViewById(R.id.department);
        result=(TextView)this.findViewById(R.id.result);
        name3=(TextView)this.findViewById(R.id.name3);
        nutrition11=(TextView)this.findViewById(R.id.nutrition11);
        nutrition12=(TextView)this.findViewById(R.id.nutrition12);
        nutrition21=(TextView)this.findViewById(R.id.nutrition21);
        nutrition22=(TextView)this.findViewById(R.id.nutrition22);
        nutrition31=(TextView)this.findViewById(R.id.nutrition31);
        nutrition32=(TextView)this.findViewById(R.id.nutrition32);
        nutrition14=(TextView)this.findViewById(R.id.nutrition14);
        nutrition24=(TextView)this.findViewById(R.id.nutrition24);
        nutrition34=(TextView)this.findViewById(R.id.nutrition34);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String source = intent.getStringExtra("source");
        name1.setText(name);
        address.setText(source);
        name2.setText(name);
        name3.setText(name);

        if(name1.getText().equals("德芙榛仁葡萄干巧克力")){
            img.setImageResource(R.drawable.chocolate1);
            food_address.setText("中国");
            standard.setText("GB/T 19343");
            card.setText("QS112713010002");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("费列罗榛果威化巧克力")){
            img.setImageResource(R.drawable.chocolate2);
            food_address.setText("意大利");
            standard.setText("GB/T 19343");
            card.setText("QS112713010002");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("M&M's花生牛奶巧克力")) {
            img.setImageResource(R.drawable.chocolate3);
            food_address.setText("北京");
            standard.setText("GB/T 19343");
            card.setText("QS112713010002");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("健达儿童牛奶巧克力")){
            img.setImageResource(R.drawable.chocolate4);
            food_address.setText("上海");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("好时牛奶巧克力")){
            img.setImageResource(R.drawable.chocolate5);
            food_address.setText("上海");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("乐事薯片")){
            img.setImageResource(R.drawable.chip);
            food_address.setText("中国");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("可比克薯片")){
            img.setImageResource(R.drawable.chip);
            food_address.setText("中国");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("上好佳薯片")){
            img.setImageResource(R.drawable.chip);
            food_address.setText("中国");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("DANISA/皇冠印尼进口曲奇")){
            img.setImageResource(R.drawable.cookie1);
            food_address.setText("印尼");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("好吃点甄好曲奇")){
            img.setImageResource(R.drawable.cookie2);
            food_address.setText("中国");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("爱芙黄油曲奇饼干")){
            img.setImageResource(R.drawable.cookie3);
            food_address.setText("马来西亚");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("良品铺子蔓越莓曲奇")){
            img.setImageResource(R.drawable.cookie4);
            food_address.setText("中国");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("同笑乐什锦棒棒糖")){
            img.setImageResource(R.drawable.candy1);
            food_address.setText("美国");
            standard.setText("GB/T 19343");
            card.setText("QS4401 1301 0006");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("榴莲糖")){
            img.setImageResource(R.drawable.candy2);
            food_address.setText("广东");
            standard.setText("GB/T 19343");
            card.setText("QS4451 1701 0599");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("阿尔卑斯糖果")){
            img.setImageResource(R.drawable.candy3);
            food_address.setText("中国");
            standard.setText("GB/T 19343");
            card.setText("QS4451 1701 0599");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("百事可乐")){
            img.setImageResource(R.drawable.drink1);
            food_address.setText("上海");
            standard.setText("GB/T 19343");
            card.setText("QS4451 1701 0599");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("美年达橙味碳酸汽水")){
            img.setImageResource(R.drawable.drink2);
            food_address.setText("上海");
            standard.setText("GB/T 19343");
            card.setText("QS4451 1701 0599");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("东鹏特饮")){
            img.setImageResource(R.drawable.drink3);
            food_address.setText("广东");
            standard.setText("GB/T 19343");
            card.setText("QS4451 1701 0599");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
        if(name1.getText().equals("加多宝凉茶")){
            img.setImageResource(R.drawable.drink4);
            food_address.setText("中国");
            standard.setText("GB/T 19343");
            card.setText("QS4451 1701 0599");
            department.setText("上海市产品质量监督检察院");
            result.setText("合格");
            nutrition11.setText("热量(大卡)");
            nutrition12.setText("531.11");
            nutrition21.setText("脂肪(克)");
            nutrition22.setText("33.33");
            nutrition31.setText("碳水化合物(克)");
            nutrition32.setText("54.81");
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                FoodFragment_detail.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

