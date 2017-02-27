package com.dreamers.shiweitian.QandA_page;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
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
import android.widget.ListView;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
//import com.dreamers.shiweitian.ListViewAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamers.shiweitian.JsonUtil;
import com.dreamers.shiweitian.Login_page;
import com.dreamers.shiweitian.Operaton;
import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.Report_page.Report_merchant_detail;
import com.dreamers.shiweitian.Search_page.ListViewAdapter_food;
import com.dreamers.shiweitian.User;
import com.dreamers.shiweitian.UserInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/2/14.
 */

public class QandA_detail extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter_qanda listViewAdapter;
    private List<Map<String, Object>> listItems;
    private Integer[] imgeIDs;
    private String[] title1;
    private String[] title2;
    private String[] title3 ;
    private TextView title,content,name,time;
    private ImageView send;
    private EditText editText;

    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qanda_detail);

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

        title=(TextView)this.findViewById(R.id.title);
        content=(TextView)this.findViewById(R.id.content);
        name=(TextView)this.findViewById(R.id.name);
        time=(TextView)this.findViewById(R.id.time);

        Intent intent = getIntent();
        String title0 = intent.getStringExtra("title");
        title.setText(title0);

        if(title.getText().equals("转基因食品安全否？有哪些优点和缺点？")){
            content.setText("最近用VPN翻墙出去用Google搜索了一下，有很多研究机构表明转基因食品会导致不孕不育，但都查不出原因。现在感觉基因工程好可怕。");
            name.setText("豪迈的嘟嘟");
            time.setText("2016年12月11日");
            title1 = new String[]{"张小树", "此时彼时", "Dorothy"};
            title2 = new String[]{"112", "56", "15"};
            title3 = new String[]{"转基因食品至少到目前是非常安全的，但现代遗传工程学还比较年青，说不清这些遗传改变将来会产生什么后果。\n优点：转基因食品有较多的优点：可增加作物产量；可以降低生产成本；可增强作物抗虫害、抗病毒等的能力；提高农产品耐贮性。\n例如：转基因食品——土豆；缩短作物开发的时间；摆脱四季供应；打破物种界限，不断培植新物种，生产出有利于人类健康的食品。\n缺点：转基因食品也有缺点：所谓的增产是不受环境影响的情况下得出的，如果遇到雨雪的自然灾害，也有可能减产更厉害。同时在栽培过程中，转基因作物可能演变为农田杂草；可能通过基因漂流影响其他物种；转基因食品可能会引起过敏等。",
                    "大品牌还是靠谱的。\n 首先对于转基因有一个很大的误区\n“转基因本身只是一种技术名词，无所谓好坏。说简单点，就是发现A类生物有一个缺点导致生活质量不高，B类恰好没这个缺点，那么我会考虑用一种手段把B类生物负责不出现这个缺点的基因切下来转到A的体内，希望它也好好生活，这就是转基因。\n所以切下人家一段基因移植给你，除了目的性状所拥有的信息资料，你本身的其他基因不会因此有什么改变，更不会“亡国灭种”。”\n转基因本身作为技术并没有对错之分，你可以反对转基因食品端上餐桌，可以不去穿转基因棉花做成的衣服，然而请千万不要一棒子打死科学家所作出的研究成果 ",
                    "第一：安全性\n①什么是转基因？\n转基因技术就是将人工分离和修饰过的基因导入到目的生物体的基因 组中，从而改造生物的现代分子生物技术。\n转基因技术的理论基础来源于 进化论衍生来的分子 生物学。 基因片段的来源可以是提取特定 生物体 基因组中所需要的 目的基因，也可以是 人工 合成指定序列的 DNA片段。DNA 片段被转入特定生物中，与其本身的基因组进行 重组，再从重组体中进行数代的人工选育，从而获得具有稳定表现特定的遗传 性 状的个体。\n简单的说转基因是用一种基因感染另一种基因，进行基因组重组，根据人类的要求所自行调整。\n②安全性。\n对于转基因安全与否还有待考证。\n由于转基因食品中有些成分是传统食品中从来没有的。现代生物技术将其他生物基因转入植物，将病毒、细菌和非食物品种的外源基因，以及标记基因中的抗生素抗性基因等引入食用作物，都是传统育种技术无法实现的。再者，现代遗传工程学还比较年青，谁也说不清这些遗传改变将来会产生什么后果。因此，各国对这类食品的安全检验要求比用传统方法培育生产的更加严格。截至2013年，国际上普遍采用的是以实质等同性原则为依据的安全性评价方法。\n第二：优缺点\n①优点。\n转基因食品有较多的优点：可增加作物产量；可以降低生产成本；可增强作物抗虫害、抗病毒等的能力；提高农产品耐贮性。\n例如：转基因食品——土豆；缩短作物开发的时间；摆脱四季供应；打破物种界限，不断培植新物种，生产出有利于人类健康的食品。\n②缺点。\n转基因食品也有缺点：所谓的增产是不受环境影响的情况下得出的，如果遇到雨雪的自然灾害，也有可能减产更厉害。同时在栽培过程中，转基因作物可能演变为农田杂草；可能通过基因漂流影响其他物种；转基因食品可能会引起过敏等。\n第三：民意调查\n①网络争执。\n关于转基因食品安全性的争论，近期再次蹿红网络。原央视著名主持 人崔永元和打假斗士方舟子的一场微博论战引来网络围观。\n从转基因发展开始，就有跟多关于转基因的谣言，科学家也用有力的证据证明转基因的清白。（如发生在1998年的普斯泰案）\n②民意说法。\n1.转基因食品安全既是科学问题，也是社会问题，公众有质疑的权力。将质疑等同于“传谣”，逻辑太霸道。\n2.转基因食品存在安全风险，“实质等同”不等于“实质安全”。传统食品同样需要监管，申请专利和食品安全是两个问题．反驳乏力。\n第四：禁播广告\n2014年10月，农业部向国家工商总局发函，商请要求加强对涉及转基因广告的管理。10月9日，央视广告部门官微称禁止对非转基因广告使用“更健康、更安全”等误导性广告词。\n将对涉及转基因、非转基因的产品广告加强审查，其中，在我国和全球均无转基因品种商业化种植的作物如水稻、花生及其加工品的广告，禁止使用非转基因广告词；对已有转基因品种商业化种植的大豆、油菜等产品及其加工品广告，除按规定收取证明材料外，禁止使用非转基因效果的词语，如更健康、更安全等误导性广告词。"};
            imgeIDs = new Integer[]{R.drawable.zhangxiaoshu,
                    R.drawable.cishibishi, R.drawable.dorthy,};
            num=3;
        }
        if(title.getText().equals("食品安全法对于食物流通许可有哪些规定？")){
            content.setText("请问食品安全法对于食物流通许可有哪些规定？");
            name.setText("豪迈的嘟嘟");
            time.setText("2017年1月13日");
            title1 = new String[]{"此时彼时"};
            title2 = new String[]{"56"};
            title3 = new String[]{"食品安全法\n第二十八条　禁止生产经营下列食品：\n　　（一）用非食品原料生产的食品或者添加食品添加剂以外的化学物质和其他可能危害人体健康物质的食品，或者用回收食品作为原料生产的食品；\n　　（二）致病性微生物、农药残留、兽药残留、重金属、污染物质以及其他危害人体健康的物质含量超过食品安全标准限量的食品；\n　　（三）营养成分不符合食品安全标准的专供婴幼儿和其他特定人群的主辅食品；\n　　（四）腐败变质、油脂酸败、霉变生虫、污秽不洁、混有异物、掺假掺杂或者感官性状异常的食品；\n　　（五）病死、毒死或者死因不明的禽、畜、兽、水产动物肉类及其制品；\n　　（六）未经动物卫生监督机构检疫或者检疫不合格的肉类，或者未经检验或者检验不合格的肉类制品；\n　　（七）被包装材料、容器、运输工具等污染的食品；\n　　（八）超过保质期的食品；\n　　（九）无标签的预包装食品；\n　　（十）国家为防病等特殊需要明令禁止生产经营的食品；\n　　（十一）其他不符合食品安全标准或者要求的食品。"};
            imgeIDs = new Integer[]{R.drawable.cishibishi};
            num=1;
        }
        if(title.getText().equals("鸭肉与什么搭配最有营养？")){
            content.setText("如题，鸭肉和哪些食物搭配更营养更养生?");
            name.setText("张小树");
            time.setText("2016年11月13日");
            title3 = new String[]{"公鸭肉性微寒，母鸭肉性微温。入药以老而白、白而骨乌者为佳。\n1.用老而肥大之鸭同海参炖食，具有很大的滋补功效，炖出的鸭汁，善补五脏之阴和虚痨之热。\n2.鸭肉与海带共炖食，可软化血管，降低血压，对老年性动脉硬化和高血压、心脏病有较好的疗效。\n3.鸭肉与竹笋共炖食，可治疗老年人痔疮下血。因此，民间认为鸭是“补虚劳的圣药”。\n4.鸭肉宜与山药同食，可降低胆固醇、滋补身体。\n5.鸭肉宜与红小豆同食，有利尿解毒的作用。\n6.鸭肉宜与当归同食，具有补血作用。\n7.鸭肉宜与白菜同食，可促进血液中胆固醇的代谢。\n8.肥鸭还治老年性肺结核、糖尿病、脾虚水肿、慢性支气管炎、大便燥结、慢性肾炎、浮肿；雄鸭治肺结核、糖尿病。\n鸭肉不宜与鳖肉同食，同食令人阴盛阳虚，水肿泄泻，也不可与兔肉、杨梅、核桃、鳖、木耳、胡桃、大蒜、荞麦同食。"};
            title1 = new String[]{"代码有毒"};
            title2 = new String[]{"45"};
            imgeIDs = new Integer[]{R.drawable.daimayoudu};
            num=1;
        }
        if(title.getText().equals("有什么食疗方法可以通便？")){
            content.setText("什么东西通便最好？便秘是人们常见的消化道疾病，便秘患者常常会有排便困难、排便次数减少、肛门堵塞感、腹部不适、口臭、食欲减退、乏力等困扰，那么，什么东西通便最好？");
            name.setText("Healthy");
            time.setText("2016年9月23日");
            title1 = new String[]{};
            title2 = new String[]{};
            title3 = new String[]{};
            imgeIDs = new Integer[]{};
            num=0;
        }
        if(title.getText().equals("番茄搭配哪些食物最营养？")){
            content.setText("番茄搭配哪些食物最营养？");
            name.setText("Healthy");
            time.setText("2016年10月23日");
            title1 = new String[]{};
            title2 = new String[]{};
            title3 = new String[]{};
            imgeIDs = new Integer[]{};
            num=0;
        }


        listView = (ListView) findViewById(R.id.list1);
        listItems = getListItems();
        listViewAdapter = new ListViewAdapter_qanda(this, listItems); //创建适配器
        listView.setAdapter(listViewAdapter);
        setListViewHeightBasedOnChildren(listView);
        listView.setFocusable(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                it.setClass(QandA_detail.this, Answer_detail.class);
                it.putExtra("name", listItems.get(position).get("title1").toString());//给intent添加额外数据，key为“str”,key值为"Intent Demo"
                it.putExtra("title",title.getText());
                it.putExtra("like",listItems.get(position).get("title2").toString());
                it.putExtra("content",listItems.get(position).get("title3").toString());
                startActivity(it);
            }
        });

        editText=(EditText)this.findViewById(R.id.edittext);
        send=(ImageView)this.findViewById(R.id.send);
        editText.addTextChangedListener(textWatcher);


    }
    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(editText.getText().toString().trim().length()>0) {
                send.setImageResource(R.drawable.send_green);
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final User user=(User)getApplication();
                        if(user.isLogin()==true) {
//                            new Thread(new Runnable() {
//
//                                public void run() {
//                                    Operaton operaton=new Operaton();
//                                    String result=operaton.upload("ReportServlet","0" ,user.getAccount(), editText1.getText()+"//"+editText2.getText());
//                                    Message msg=new Message();
//                                    if (result.equals("")){
//                                        user.isLogin=false;
//                                        result="举报成功";
//                                    }
//                                    msg.obj=result;
//                                    handler.sendMessage(msg);
//                                }
//                            }).start();
//                            title1[num]=user.getUsername();
//                            title2[num]="0";
//                            title3[num]=editText.getText().toString();
//                            imgeIDs[num] =R.drawable.user_photo1;
//                            Toast.makeText(getApplication(),title1[num],Toast.LENGTH_LONG).show();

//                            listItems.clear();
//                            listItems = getListItems();
//                            listViewAdapter = new ListViewAdapter_qanda(QandA_detail.this, listItems); //创建适配器
//                            listView.setAdapter(listViewAdapter);
//                            listViewAdapter.notifyDataSetChanged();
                            if(title.getText().equals("转基因食品安全否？有哪些优点和缺点？")){
                                title1 = new String[]{"张小树", "此时彼时", "Dorothy",user.getUsername()};
                                title2 = new String[]{"112", "56", "15","0"};
                                title3 = new String[]{"转基因食品至少到目前是非常安全的，但现代遗传工程学还比较年青，说不清这些遗传改变将来会产生什么后果。\n优点：转基因食品有较多的优点：可增加作物产量；可以降低生产成本；可增强作物抗虫害、抗病毒等的能力；提高农产品耐贮性。\n例如：转基因食品——土豆；缩短作物开发的时间；摆脱四季供应；打破物种界限，不断培植新物种，生产出有利于人类健康的食品。\n缺点：转基因食品也有缺点：所谓的增产是不受环境影响的情况下得出的，如果遇到雨雪的自然灾害，也有可能减产更厉害。同时在栽培过程中，转基因作物可能演变为农田杂草；可能通过基因漂流影响其他物种；转基因食品可能会引起过敏等。",
                                        "大品牌还是靠谱的。\n 首先对于转基因有一个很大的误区\n“转基因本身只是一种技术名词，无所谓好坏。说简单点，就是发现A类生物有一个缺点导致生活质量不高，B类恰好没这个缺点，那么我会考虑用一种手段把B类生物负责不出现这个缺点的基因切下来转到A的体内，希望它也好好生活，这就是转基因。\n所以切下人家一段基因移植给你，除了目的性状所拥有的信息资料，你本身的其他基因不会因此有什么改变，更不会“亡国灭种”。”\n转基因本身作为技术并没有对错之分，你可以反对转基因食品端上餐桌，可以不去穿转基因棉花做成的衣服，然而请千万不要一棒子打死科学家所作出的研究成果 ",
                                        "第一：安全性\n①什么是转基因？\n转基因技术就是将人工分离和修饰过的基因导入到目的生物体的基因 组中，从而改造生物的现代分子生物技术。\n转基因技术的理论基础来源于 进化论衍生来的分子 生物学。 基因片段的来源可以是提取特定 生物体 基因组中所需要的 目的基因，也可以是 人工 合成指定序列的 DNA片段。DNA 片段被转入特定生物中，与其本身的基因组进行 重组，再从重组体中进行数代的人工选育，从而获得具有稳定表现特定的遗传 性 状的个体。\n简单的说转基因是用一种基因感染另一种基因，进行基因组重组，根据人类的要求所自行调整。\n②安全性。\n对于转基因安全与否还有待考证。\n由于转基因食品中有些成分是传统食品中从来没有的。现代生物技术将其他生物基因转入植物，将病毒、细菌和非食物品种的外源基因，以及标记基因中的抗生素抗性基因等引入食用作物，都是传统育种技术无法实现的。再者，现代遗传工程学还比较年青，谁也说不清这些遗传改变将来会产生什么后果。因此，各国对这类食品的安全检验要求比用传统方法培育生产的更加严格。截至2013年，国际上普遍采用的是以实质等同性原则为依据的安全性评价方法。\n第二：优缺点\n①优点。\n转基因食品有较多的优点：可增加作物产量；可以降低生产成本；可增强作物抗虫害、抗病毒等的能力；提高农产品耐贮性。\n例如：转基因食品——土豆；缩短作物开发的时间；摆脱四季供应；打破物种界限，不断培植新物种，生产出有利于人类健康的食品。\n②缺点。\n转基因食品也有缺点：所谓的增产是不受环境影响的情况下得出的，如果遇到雨雪的自然灾害，也有可能减产更厉害。同时在栽培过程中，转基因作物可能演变为农田杂草；可能通过基因漂流影响其他物种；转基因食品可能会引起过敏等。\n第三：民意调查\n①网络争执。\n关于转基因食品安全性的争论，近期再次蹿红网络。原央视著名主持 人崔永元和打假斗士方舟子的一场微博论战引来网络围观。\n从转基因发展开始，就有跟多关于转基因的谣言，科学家也用有力的证据证明转基因的清白。（如发生在1998年的普斯泰案）\n②民意说法。\n1.转基因食品安全既是科学问题，也是社会问题，公众有质疑的权力。将质疑等同于“传谣”，逻辑太霸道。\n2.转基因食品存在安全风险，“实质等同”不等于“实质安全”。传统食品同样需要监管，申请专利和食品安全是两个问题．反驳乏力。\n第四：禁播广告\n2014年10月，农业部向国家工商总局发函，商请要求加强对涉及转基因广告的管理。10月9日，央视广告部门官微称禁止对非转基因广告使用“更健康、更安全”等误导性广告词。\n将对涉及转基因、非转基因的产品广告加强审查，其中，在我国和全球均无转基因品种商业化种植的作物如水稻、花生及其加工品的广告，禁止使用非转基因广告词；对已有转基因品种商业化种植的大豆、油菜等产品及其加工品广告，除按规定收取证明材料外，禁止使用非转基因效果的词语，如更健康、更安全等误导性广告词。",
                                        editText.getText().toString()};
                                imgeIDs = new Integer[]{R.drawable.zhangxiaoshu,
                                        R.drawable.cishibishi, R.drawable.dorthy,R.drawable.user_photo1};
                            }
                            if(title.getText().equals("食品安全法对于食物流通许可有哪些规定？")){
                                title1 = new String[]{"此时彼时",user.getUsername()};
                                title2 = new String[]{"56","0"};
                                title3 = new String[]{"食品安全法\n第二十八条　禁止生产经营下列食品：\n　　（一）用非食品原料生产的食品或者添加食品添加剂以外的化学物质和其他可能危害人体健康物质的食品，或者用回收食品作为原料生产的食品；\n　　（二）致病性微生物、农药残留、兽药残留、重金属、污染物质以及其他危害人体健康的物质含量超过食品安全标准限量的食品；\n　　（三）营养成分不符合食品安全标准的专供婴幼儿和其他特定人群的主辅食品；\n　　（四）腐败变质、油脂酸败、霉变生虫、污秽不洁、混有异物、掺假掺杂或者感官性状异常的食品；\n　　（五）病死、毒死或者死因不明的禽、畜、兽、水产动物肉类及其制品；\n　　（六）未经动物卫生监督机构检疫或者检疫不合格的肉类，或者未经检验或者检验不合格的肉类制品；\n　　（七）被包装材料、容器、运输工具等污染的食品；\n　　（八）超过保质期的食品；\n　　（九）无标签的预包装食品；\n　　（十）国家为防病等特殊需要明令禁止生产经营的食品；\n　　（十一）其他不符合食品安全标准或者要求的食品。",
                                        editText.getText().toString()};
                                imgeIDs = new Integer[]{R.drawable.cishibishi,R.drawable.user_photo1};
                            }
                            if(title.getText().equals("鸭肉与什么搭配最有营养？")){
                                title3 = new String[]{"公鸭肉性微寒，母鸭肉性微温。入药以老而白、白而骨乌者为佳。\n1.用老而肥大之鸭同海参炖食，具有很大的滋补功效，炖出的鸭汁，善补五脏之阴和虚痨之热。\n2.鸭肉与海带共炖食，可软化血管，降低血压，对老年性动脉硬化和高血压、心脏病有较好的疗效。\n3.鸭肉与竹笋共炖食，可治疗老年人痔疮下血。因此，民间认为鸭是“补虚劳的圣药”。\n4.鸭肉宜与山药同食，可降低胆固醇、滋补身体。\n5.鸭肉宜与红小豆同食，有利尿解毒的作用。\n6.鸭肉宜与当归同食，具有补血作用。\n7.鸭肉宜与白菜同食，可促进血液中胆固醇的代谢。\n8.肥鸭还治老年性肺结核、糖尿病、脾虚水肿、慢性支气管炎、大便燥结、慢性肾炎、浮肿；雄鸭治肺结核、糖尿病。\n鸭肉不宜与鳖肉同食，同食令人阴盛阳虚，水肿泄泻，也不可与兔肉、杨梅、核桃、鳖、木耳、胡桃、大蒜、荞麦同食。"};
                                title1 = new String[]{"代码有毒",user.getUsername()};
                                title2 = new String[]{"45","0"};
                                imgeIDs = new Integer[]{R.drawable.daimayoudu,R.drawable.user_photo1};
                                num=1;
                            }
                            if(title.getText().equals("有什么食疗方法可以通便？")){
                                title1 = new String[]{};
                                title2 = new String[]{};
                                title3 = new String[]{};
                                imgeIDs = new Integer[]{};
                                num=0;
                            }
                            if(title.getText().equals("番茄搭配哪些食物最营养？")){
                                title1 = new String[]{};
                                title2 = new String[]{};
                                title3 = new String[]{};
                                imgeIDs = new Integer[]{};
                                num=0;
                            }
                            listItems.clear();
                            listItems = getListItems();
                            listViewAdapter = new ListViewAdapter_qanda(QandA_detail.this, listItems); //创建适配器
                            listView.setAdapter(listViewAdapter);
                            listViewAdapter.notifyDataSetChanged();

                            editText.setText("");
                            Toast.makeText(getApplication(),"发送成功",Toast.LENGTH_SHORT).show();


                        }
                        else {
                            Intent it =new Intent();
                            it.setClass(QandA_detail.this, Login_page.class);
                            startActivityForResult(it,4);
                        }
                    }
                });
            }
            else
                send.setImageResource(R.drawable.send_gray);


        }
    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                QandA_detail.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 初始化商品信息
     */
    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < title1.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", imgeIDs[i]);     //物品名称
            map.put("title1", title1[i]);               //图片资源
            map.put("title2", title2[i]);              //物品标题
            map.put("title3", title3[i]);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == 0) {  //返回成功
            switch (requestCode) {
                case 4: {//从Personal_information返回
                    User user=(User)getApplication();
                    if(user.isLogin()==true) {

                        Intent intent = getIntent();
                        //从Intent当中根据key取得value
                        Bundle bundle2 = data.getBundleExtra("bundle2");
                        final String account = bundle2.getString("strResult");
                        new Thread(new Runnable() {

                            public void run() {
                                Operaton operaton = new Operaton();
                                String result = operaton.userInfo("UserServlet", account);
                                List<UserInfo> list = JsonUtil.StringFromJson1(result);

                                ArrayList<UserInfo> newlist = new ArrayList<>();

                                for (int i = 0; i < list.size(); i++) {
                                    newlist.add(list.get(i));
                                }
                                Message msg = new Message();
                                User helper = new User();
                                helper.setTemp_list1(newlist);
                                helper.setIsget_templist(true);
                                msg.obj = helper;
                                handler.sendMessage(msg);

                            }
                        }).start();
                    }

                    break;
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            User help=(User) msg.obj;
            ArrayList<UserInfo> temp=help.getTemp_list1();
            User user=(User)getApplication();
            for(int i=0;i<help.getTemp_list1().size();i++){
               user.setUsername(help.getTemp_list1().get(i).getName());

            }

            super.handleMessage(msg);
        }
    };

}

