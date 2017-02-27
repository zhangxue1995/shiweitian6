package com.dreamers.shiweitian.News_page;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.R;

/**
 * Created by stzha on 2017/2/16.
 */

public class News_detail_withoutimg extends AppCompatActivity {
    private TextView title,source,date,content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_withoutimg);

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
        actionBar.setTitle("                 资讯");

        Intent intent = getIntent();
        //从Intent当中根据key取得value
        String title1 = intent.getStringExtra("title");
        String source1 = intent.getStringExtra("source");
        String content1 = intent.getStringExtra("content");
//        String date1 = intent.getStringExtra("time");

        title=(TextView)this.findViewById(R.id.title);
        source=(TextView)this.findViewById(R.id.source);
        date=(TextView)this.findViewById(R.id.time);
        content=(TextView)this.findViewById(R.id.content);

        title.setText(title1);
        source.setText(source1);
        content.setText(content1);

        if(title1.equals("习近平对食品安全工作作出重要指示强调"))
        {
            content.setText("　　中共中央总书记、国家主席、中央军委主席习近平日前对食品安全工作作出重要指示指出，民以食为天，加强食品安全工作，关系我国13亿多人的身体健康和生命安全，必须抓得紧而又紧。这些年，党和政府下了很大气力抓食品安全，食品安全形势不断好转，但存在的问题仍然不少，老百姓仍然有很多期待，必须再接再厉，把工作做细做实，确保人民群众“舌尖上的安全”。\n" +
                    "\n" +
                    "    习近平强调，各级党委和政府及有关部门要全面做好食品安全工作，坚持最严谨的标准、最严格的监管、最严厉的处罚、最严肃的问责，增强食品安全监管统一性和专业性，切实提高食品安全监管水平和能力。要加强食品安全依法治理，加强基层基础工作，建设职业化检查员队伍，提高餐饮业质量安全水平，加强从“农田到餐桌”全过程食品安全工作，严防、严管、严控食品安全风险，保证广大人民群众吃得放心、安心。\n" +
                    "\n" +
                    "    中共中央政治局常委、国务院总理李克强作出批示指出，食品安全是全面建成小康社会的重要标志。新的一年，面对依然复杂严峻的食品安全形势，要认真贯彻党中央、国务院决策部署，把保障食品安全放在更加突出的位置，完善食品安全监管体制机制，大力实施食品安全战略。要切实发挥食安委统一领导、食安办综合协调作用，坚持源头控制、产管并重、重典治乱，夯实各环节、各方面的责任，着力提高监管效能，凝聚社会共治合力，进一步治理“餐桌污染”，推动食品安全形势持续改善，不断提高人民群众满意度和获得感。\n" +
                    "\n" +
                    "    中共中央政治局常委、国务院副总理、国务院食品安全委员会主任张高丽3日主持召开国务院食品安全委员会第四次全体会议并讲话。会议认真学习习近平重要指示和李克强批示精神，全面总结2016年食品安全工作，研究部署2017年重点工作。\n" +
                    "\n" +
                    "    张高丽表示，当前，食品安全形势依然严峻复杂，影响食品安全的深层次问题还没有根本解决。要坚持严字当头，把食品安全工作作为一项重大政治任务和保障民生工程来抓，坚决守护好人民群众“舌尖上的安全”。\n" +
                    "\n" +
                    "    张高丽强调，保障食品安全是全面建成小康社会的迫切需要，是推进供给侧结构性改革的重要举措。要加快完善食品安全标准体系，抓紧制定一些急需的标准，推动食品安全标准与国际标准对接，用最严谨的标准为食品安全提供基础性制度保障。要坚持源头严防、过程严管、风险严控，对生产经营过程采取彻查隐患、处罚到人、公开信息的综合措施，用最严格的监管守住不发生系统性区域性食品安全风险的底线。要完善食品安全行政执法程序，严格落实食品安全法有关规定，完善办理危害食品安全刑事案件的司法解释，推动掺假造假行为直接入刑，用最严厉的处罚坚决遏制和打击违法犯罪行为。要不折不扣落实食品安全责任制，研究制定食品安全工作问责办法，用最严肃的问责推动各地区各部门切实依法履职尽责。要把餐饮食品安全作为一项重大民生工程来抓，全面治理“餐桌污染”，提高餐饮业质量安全水平。\n" +
                    "\n" +
                    "张高丽指出，要进一步加强组织保障，加快完善统一权威的食品药品安全监管体制，抓紧印发实施《“十三五”国家食品安全规划》，加大对食品安全工作的投入力度，加强基层监管力量和基础设施建设，加快建设职业化食品检查员队伍，增强对食品安全工作的各项保障。近期，各地区各有关部门要迅速行动起来，全面排查风险隐患，全力保障节日和两会期间的食品安全。\n");
            date.setText("2017年01月04日");
        }
        if(title1.equals("无锡局食品生产许可工作获全省第二名"))
        {
            content.setText("　　近日，无锡局在省局食品生产监管处组织的食品生产许可工作考核中，取得了总分全省第二的优异成绩，获得了省局领导的肯定。为进一步加强食品生产许可工作，提升行政许可效能，做到依法行政、高效便民，省局食品生产监管处2017年1月16日至17日组织开展了全省生产许可材料的考核工作，共抽取无锡市食品生产许可档案10份，对各节点时效、申请材料技术合规性、现场核查准确性等进行了全面细致的考核。\n" +
                    "\n" +
                    "2016年，无锡局积极应对食品生产许可审批权限下放，先后出台了《无锡市食品生产许可工作规范》、《无锡市食品生产许可工作质量监督检查管理办法》、《无锡市食品生产许可核查人员管理办法》等一系列制度，采取异地互查、证前核查和证后抽查的形式加强工作质量考核，取得了较好的效果，全市生产许可工作质量得到较大幅度提升。2016年，全市共受理食品生产许可申请材料272份，其中不予许可22份，注销食品生产许可证113张，在办件数量较多的情况下实现了许可工作零投诉。\n");
            date.setText("2017年02月17日");
        }
        if(title1.equals("锡山区市场监管局全面完成药品零售企业医疗机构药品质量安全信用等级评定工作"))
        {
            content.setText("　　为提高药品零售企业、医疗机构的诚信意识，加强对药品零售企业、医疗机构药品经营和使用监督管理，切实保障药品零售企业、医疗机构药品质量安全，近日，锡山区市场监督管理局按照《江苏省零售药店药品安全信用等级评价标准（试行）》、《无锡市医疗机构药品质量安全信用等级评定管理办法（暂行）》等相关要求，对全区217家药品零售企业和17家一级以上医疗机机构开展药品质量安全信用等级评定工作。经综合评定，无锡汇华强盛医药连锁有限公司八士第一药店等197家评定为A级，无锡市锡山区东港镇放心药店有限公司等10家评定为B级，无药品零售企业评定为C级或D级, 其他10家药品零售企业因开办未满一年或报停等原因不参与评定。经初步评定，无锡市锡山人民医院、无锡市锡山人民医院东亭分院等17家一级以上医疗机构评定为A级。药品零售企业和医疗机构药品质量安全信用等级评定结果将在锡山区市场监督管理局网站予以公告，接受社会监督，同时，锡山局将实施分级分类监管模式，着重加大对信用等级评定为B级的药品零售企业监督检查力度，进一步规范药品经营行为，确保药品质量安全。");
            date.setText("2017年02月16日");
        }
        if(title1.equals("无锡局四举措强化保健食品抽检工作"))
        {
            content.setText("　　无锡市局采取四项措施，扎实开展保健食品抽检及安全风险监测工作。\n" +
                    "\n" +
                    "    一是严格周密组织，增强抽检可行性。无锡市局通过公开招标确定承检单位，同时制定保健食品抽检工作方案，进一步明确抽样地点、品种和抽检期限，切实增强了监督抽检工作的可操作性。\n" +
                    "\n" +
                    "    二是靶向明确，加大保健食品市场抽查力度。将减肥类、辅助降糖、辅助降血压、缓解体力疲劳等易添加违禁成分的保健食品，以及投诉举报产品作为抽样重点品种，将保健食品批发市场、集散地、大型商场超市等作为重点区域，强化节日期间市场的抽检力度。\n" +
                    "\n" +
                    "    三是培训助力，提高效能完成快速监测任务。对7个市（县）、区配置保健食品快速检测工具，聘请人员对基层执法人员进行快筛培训，将快速检验与抽样检验相结合，充分发挥“快速筛查、靶向抽样”的效能。\n" +
                    "\n" +
                    "    四是信息公示，有效发挥抽检结果作用。严格实施统一数据汇总分析、统一结果利用的保健食品抽检工作机制，及时对保健食品产品抽检信息进行了公示，引导群众正确消费。同时，加强对检验不合格产品的督查督办工作。\n" +
                    "\n" +
                    "2016年，已完成市级保健食品抽验任务202批次，快速检验130批次，发现不合格产品3批次。无锡市局根据信息公开要求对检测合格及不合格产品信息予以公示，同时对不合格产品的核查进行跟踪督办。\n");
            date.setText("2017年02月16日");
        }
        if(title1.equals("无锡市食品生产监管条线正式使用电子监管系统"))
        {
            content.setText("　　为加强基层食品生产监管的信息化建设，有效使用信息化手段提高基层监管效率，实现食品生产监管台账的信息化、食品质量安全监管的信息化，无锡市食品生产监管条线于2017年1月1日起正式使用电子监管系统。\n" +
                    "\n" +
                    "    无锡市食品生产电子监管系统是山东省标准化研究院为食品生产环节量身定做的。电子监管系统实现了企业档案电子化，企业的所有信息都可在电子监管系统中查询；监管作业移动化，电子监管系统做成了移动终端，边检查边录入，当场打印文书；数据分析自动化，电子监管系统中可以自动生成三分监管、报表等信息。\n" +
                    "\n" +
                    "    电子监管系统有网页版和移动终端版，市局、区局、分局负责人在网页版电子监管系统中制定监督检查任务并下达给执行单位，执行单位接收到任务后，选择执行任务的人员分组。监管人员可以在现场用移动终端版电子监管系统进行监督检查，边检查边录入信息，当场生成监督检查文书并用蓝牙打印机现场打印。\n" +
                    "\n" +
                    "    电子监管系统中配套了与生产许可、日常监管、行政处罚相关的法律条款、政策法规、审查细则、添加剂库等，便于监管人员免于携带厚重的资料，直接在电子监管系统中查找。\n" +
                    "\n" +
                    "    监管人员每次进行监督检查后，电子监管系统中会自动生成检查次数、发现问题等情况的日常监管情况统计报表，便于监管人员定期上报。\n" +
                    "\n" +
                    "    全市食品生产监管条线范围内正式使用电子监管系统将完善食品安全监管信息化建设，规范工作程序，提升工作效率。\n" +
                    "\n" +
                    "    这项工作，是2016年智慧江苏食品药品监管行业应用示范工程。目前全省仅我市和南京投入使用。\n");
            date.setText("2017年02月20日");
        }
        if(title1.equals("无锡出台制度规范食品安全监督抽检后处理工作"))
        {
            content.setText("　　为规范食品安全监督抽检不合格食品后处理工作，充分发挥监督抽检在食品安全监管中的作用，近日，无锡市食品药品监管局出台了《无锡市食品安全监督抽检不合格产品后处理工作程序规定》，明确了后处理、职责分工、工作程序要求等事项。\n" +
                    "\n" +
                    "    一是明确职责分工。规定市局负责不合格食品后处理的组织、协调、汇总和信息反馈工作。各市（县）、区局负责组织实施各级监督抽检不合格食品后处理工作，建立、完善后处理工作记录和档案。各级稽查执法大队完成行政处罚后，汇总上报后处理信息。\n" +
                    "\n" +
                    "    二是规范不合格结果告知程序。为确保后处理工作时效性，该程序规定明确规定了送达报告至复检各个阶段的时间要求。市局收到省、市食品安全监督抽检不合格报告后，在5个工作日内将不合格样品报告移送至被抽样单位所在地的市（县）、区局。监督抽检不合格产品涉及省内其他地市生产的，市局收到报告后5个工作日内通报问题产品标示所在地市食品药品监督管理局。\n" +
                    "\n" +
                    "    三是规范不合格产品核查处置工作。各市（县）、区局收到不合格检验报告后，应立即对企业库存涉嫌不合格产品采取措施，防止再次流入市场。食品生产经营者可以自收到检验结论之日起七个工作日内提出复检申请。对监督抽检不合格产品负有核查处置职责的市（县）、区局原则上30日内完成核查处置工作。\n" +
                    "\n" +
                    "四是加强分析研判和风险交流。负责不合格产品核查处置的市（县）、区局应督促开展问题产生原因的分析调查及整改工作。对不合格产品生产者开展复查，并加强对不合格产品及同类食品的跟踪抽检。对于存在严重危害人体健康物质的产品，根据工作需要，可以组织开展专项执法检验工作。\n");
            date.setText("2017年02月04日");
        }
        if(title1.equals("无锡市春节长假食品药品安全形势平稳,未发生食品药品安全突发事件"))
        {
            content.setText("　　2017年春节期间，无锡市食品药品监督管理局积极开展食品药品市场监督检查，严格落实值班制度，保障了春节食品药品市场安全形势平稳。\n" +
                    "\n" +
                    "    一是加强领导，落实监管责任。节前市食品药品监管局专题研究部署春节期间食品药品安全监管工作，制定专门方案,组织各地各部门高度重视节日期间食品药品安全工作，认真安排部署，加强统筹协调，狠抓工作落实。\n" +
                    "\n" +
                    "    二是加大巡查，确保市场安全。组织了针对食品药品生产、流通、消费各环节的执法检查，督促企业规范内部管理，对检查发现的问题进行及时处置并跟踪检查，有效防控重大食品药品安全事故的发生。\n" +
                    "\n" +
                    "    三是强化抽检，及时排除隐患。以城郊、农村、校园周边等为重点地区，以食品批发市场、农贸市场、超市、食杂店等为重点单位，以节日热销、近期抽检不合格集中、消费者投诉举报多的食品为重点品种，开展专项抽检，对销售问题食品的违法违章行为依法进行查处，并及时追根溯源。\n" +
                    "\n" +
                    "    四是严格值守，防控突发事件。春节期间，认真部署落实领导带班和工作人员值班制，完善突发事件应急处置预案，严肃值班纪律，收集报送当日食品药品安全监管情况。春节长假期间，全市未发生食品（药品、医疗器械）突发事件，食品药品市场秩序良好。\n");
            date.setText("2017年02月03日");
        }

        if(title1.equals("南雄开展食品药品安全知识进校园宣传活动"))
        {
            content.setText("　　为进一步提高中小学生的食品药品安全意识，推动校园食品药品安全工作深入开展，日前，南雄市珠玑食品药品监督管理所在珠玑镇中心小学内开展了食品药品安全知识进校园宣传活动。\n" +
                    "此次活动以“食品药品安全，从我做起”为主题展开，倡导“饮食安全，健康生活”，提醒广大师生，自觉抵制不合格食品、自觉注意个人卫生，掌握预防食物中毒的基本常识，如何应对食物中毒突发事件等知识。工作人员在现场派发宣传资料300多份，其中有形象生动的宣传画册，帮助孩子们更好地掌握食品安全知识，活动收到了良好的社会效果。\n");
            date.setText("2017年02月21日");
        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                News_detail_withoutimg.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
