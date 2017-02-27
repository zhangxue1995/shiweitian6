package com.dreamers.shiweitian.Report_page;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.Search_page.ListViewAdapter_food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/1/9.
 */

public class Feedback_detail extends AppCompatActivity {

    private ImageView img1,img2,img3;
    private ImageView dot1,dot2,dot3,dot4,dot5,dot6,dot7,dot8,dot9,dot10,dot11;
    private TextView tv1,tv2,tv3;
    private TextView text1,text2,text3,text4;
    private TextView t5,t6,t7,t8,t9;
    private View line,line8,line9;
    private ImageView satisfaction,dissatisfaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_detail);

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
        actionBar.setTitle("             举报跟踪");


        TextView tv1 = (TextView)findViewById(R.id.tv1);//文字粗体
        TextPaint tp1 = tv1.getPaint();
        tp1.setFakeBoldText(true);
        TextView tv2 = (TextView)findViewById(R.id.tv2);//文字粗体
        TextPaint tp2 = tv2.getPaint();
        tp2.setFakeBoldText(true);
        TextView tv3 = (TextView)findViewById(R.id.tv3);//文字粗体
        TextPaint tp3 = tv3.getPaint();
        tp3.setFakeBoldText(true);

        img1=(ImageView)this.findViewById(R.id.img1);
        img2=(ImageView)this.findViewById(R.id.img2);
        img3=(ImageView)this.findViewById(R.id.img3);
        dot1=(ImageView)this.findViewById(R.id.dot1);dot2=(ImageView)this.findViewById(R.id.dot2);
        dot3=(ImageView)this.findViewById(R.id.dot3);dot4=(ImageView)this.findViewById(R.id.dot4);
        dot5=(ImageView)this.findViewById(R.id.dot5);dot6=(ImageView)this.findViewById(R.id.dot6);
        dot7=(ImageView)this.findViewById(R.id.dot7);dot8=(ImageView)this.findViewById(R.id.dot8);
        dot9=(ImageView)this.findViewById(R.id.dot9);dot10=(ImageView)this.findViewById(R.id.dot10);
        dot11=(ImageView)this.findViewById(R.id.dot11);

        t5=(TextView)this.findViewById(R.id.t5);
        t6=(TextView)this.findViewById(R.id.t6);
        t7=(TextView)this.findViewById(R.id.t7);
        t8=(TextView)this.findViewById(R.id.t8);
        t9=(TextView)this.findViewById(R.id.t9);

        line=(View)this.findViewById(R.id.line7);
        line8=(View)this.findViewById(R.id.line8);
        line9=(View)this.findViewById(R.id.line9);

        satisfaction=(ImageView)this.findViewById(R.id.satisfaction);
        dissatisfaction=(ImageView)this.findViewById(R.id.dissatisfaction);

        Intent intent=getIntent();//getIntent将该项目中包含的原始intent检索出来，将检索出来的intent赋值给一个Intent类型的变量intent
        Bundle bundle=intent.getExtras();//.getExtras()得到intent所附带的额外数据
        String str1=bundle.getString("str1");//getString()返回指定key的值
        String str2=bundle.getString("str2");
        if(str1.equals("已提交")){
            img1.setBackgroundResource(R.drawable.location);
            dot1.setImageResource(R.drawable.dot1_green);
            tv1.setTextColor(Color.BLACK);

            line.setVisibility(View.INVISIBLE);
//            t5.setText("您的举报已成功提交！正等待相关部门受理");
//            t6.setText("预计受理时间："+"2017年3月14日前");
            t7.setVisibility(View.INVISIBLE);
            t8.setVisibility(View.INVISIBLE);
            t9.setVisibility(View.INVISIBLE);
            line8.setVisibility(View.INVISIBLE);
            line9.setVisibility(View.INVISIBLE);
            satisfaction.setVisibility(View.INVISIBLE);
            dissatisfaction.setVisibility(View.INVISIBLE);


        }
        if(str1.equals("已受理")){
            img2.setBackgroundResource(R.drawable.location);
            dot1.setImageResource(R.drawable.dot1_green);dot2.setImageResource(R.drawable.dot1_green);
            dot3.setImageResource(R.drawable.dot1_green);dot4.setImageResource(R.drawable.dot1_green);
            dot5.setImageResource(R.drawable.dot1_green);dot6.setImageResource(R.drawable.dot1_green);
            tv1.setTextColor(Color.BLACK);tv2.setTextColor(Color.BLACK);

//            t5.setText("处理时间："+"2017年1月12日");
//            t6.setText("处理部门："+"滨湖区卫生局");
//            t7.setText("处理意见："+"经调查，该餐厅确实存在使用廉价地沟油的问题，现已责令其进行停业整改。");

            satisfaction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    satisfaction.setImageResource(R.drawable.satisfaction_green);
                    t8.setTextColor(Color.parseColor("#FF4CAF50"));
                    dissatisfaction.setImageResource(R.drawable.dissatisfaction_gray);
                    t9.setTextColor(Color.parseColor("#aa000000"));
                }
            });
            dissatisfaction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dissatisfaction.setImageResource(R.drawable.dissatisfaction_green);
                    t9.setTextColor(Color.parseColor("#FF4CAF50"));
                    satisfaction.setImageResource(R.drawable.satisfaction_gray);
                    t8.setTextColor(Color.parseColor("#aa000000"));
                }
            });

        }
        text1=(TextView)this.findViewById(R.id.text1);
        text2 = (TextView) this.findViewById(R.id.text2);
        text3 = (TextView) this.findViewById(R.id.text3);
        text4 = (TextView) this.findViewById(R.id.text4);
        text1.setText("举报对象："+str2);

        if(str2.equals("华莱士（公道店）")) {
            text2.setText("地址：" + "公道镇人民路好又多购物中心");
            text3.setText("举报原因：" + "出售过期食品");
            text4.setText("问题详情：" + "免费续杯的可乐气不足，喝上去就像糖水一样，根本没有可乐的劲道。怀疑放了很久了。请店家出示添加可乐的时间证明以及可乐瓶等证明，店家无法出示。怀疑店家将过期可乐掺水售卖给消费者。");
            t5.setText("您的举报已成功提交！正等待相关部门受理");
            t6.setText("预计受理时间："+"2017年3月14日前");
        }
        if(str2.equals("海底捞（凯德广场店）")) {
            text2.setText("地址：" + "武汉市硚口区中山大道238号凯德广场5-6楼");
            text3.setText("举报原因：" + "菜品不新鲜");
            text4.setText("问题详情：" + "菌汤有股苦霉味，辣锅有一丢丢红油飘在上面，菜品不新鲜，羊肉口感很奇怪。");
            t5.setText("处理时间："+"2017年1月12日");
            t6.setText("处理部门："+"硚口区卫生局");
            t7.setText("处理意见："+"经调查，该餐厅确实存在使用市场上不新鲜的蔬菜和肉类等问题，现已责令其进行停业整改。");
        }
        if(str2.equals("德芙巧克力（308g）")) {
            text2.setText("地址：" + "玛氏食品(中国)有限公司");
            text3.setText("举报原因：" + "出售过期食品");
            text4.setText("问题详情：" + "新购买的一盒德芙巧克力，发现里面已经快要融化，感觉自己买了一盒假德芙。(￢_￢)(￢_￢)");
            t5.setText("处理时间："+"2016年12月9日");
            t6.setText("处理部门："+"无锡市卫生局");
            t7.setText("处理意见："+"经调查，您购买的德芙巧克力并没有出现过期问题，应该是由于天气热的原因，导致巧克力融化，属于正常现象。");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Feedback_detail.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
