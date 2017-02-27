package com.dreamers.shiweitian.QandA_page;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamers.shiweitian.CircleImageView;
import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.JsonUtil;
import com.dreamers.shiweitian.Login_page;
import com.dreamers.shiweitian.Operaton;
import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.User;
import com.dreamers.shiweitian.UserInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/2/25.
 */

public class Answer_detail extends AppCompatActivity {

    private String title1;
    private String title2;
    private String title3;
    private String title4;
    private TextView content,name,time,like_num;
    private CircleImageView photo;
    private ImageView like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_detail);

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
        actionBar.setTitle("                 详情");

        content=(TextView)this.findViewById(R.id.title3);
        name=(TextView)this.findViewById(R.id.title1);
        like_num=(TextView)this.findViewById(R.id.title2);
        time=(TextView)this.findViewById(R.id.time);
        photo=(CircleImageView)this.findViewById(R.id.image);
        like=(ImageView)this.findViewById(R.id.like);


        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name");
        String title1 = intent.getStringExtra("title");
        final String like1 = intent.getStringExtra("like");
        String content1 = intent.getStringExtra("content");
        name.setText(name1);
        like_num.setText(like1);
        content.setText(content1);

        if(title1.equals("转基因食品安全否？有哪些优点和缺点？")&&name.getText().equals("张小树")){
            time.setText("2016年12月11日");
            photo.setImageResource(R.drawable.zhangxiaoshu);
        }
        if(title1.equals("转基因食品安全否？有哪些优点和缺点？")&&name.getText().equals("此时彼时")){
            time.setText("2016年12月13日");
            photo.setImageResource(R.drawable.cishibishi);
        }
        if(title1.equals("转基因食品安全否？有哪些优点和缺点？")&&name.getText().equals("Dorothy")){
            time.setText("2017年1月20日");
            photo.setImageResource(R.drawable.dorthy);
        }
        if(title1.equals("食品安全法对于食物流通许可有哪些规定？")&&name.getText().equals("此时彼时")){
            time.setText("2017年1月21日");
            photo.setImageResource(R.drawable.dorthy);
        }
        if(title1.equals("鸭肉与什么搭配最有营养？")&&name.getText().equals("代码有毒")){
            time.setText("2016年12月21日");
            photo.setImageResource(R.drawable.daimayoudu);
        }

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                like.setImageResource(R.drawable.satisfaction_green);
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Answer_detail.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}