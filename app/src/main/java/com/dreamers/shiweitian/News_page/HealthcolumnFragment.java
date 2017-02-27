package com.dreamers.shiweitian.News_page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dreamers.shiweitian.JsonUtil;
import com.dreamers.shiweitian.Operaton;
import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by stzha on 2017/1/8.
 */

public class HealthcolumnFragment extends Fragment {

    private String[] title;
    private String[] source;
    private String[] date=new String[100];
    private String[] photo=new String[100];
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

    private View rootView;
    private Bitmap bitmap;
    private TextView reloading;

    public HealthcolumnFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (isNetworkConnected(getContext())==false) {
            View rootView = inflater.inflate(R.layout.recommend, container, false);
            reloading=(TextView) rootView.findViewById(R.id.a2);
            reloading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Dialog dialog = new Dialog(getActivity(),R.style.Translucent_NoTitle);

                    dialog.setContentView(R.layout.loading);
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);

                    final Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        public void run() {
                            dialog.dismiss();
                            t.cancel();
                        }
                    }, 2000);


                }
            });
            return rootView;
        }
        else {
            rootView = inflater.inflate(R.layout.healthcolumn_load, container, false);
            listView = (ListView) rootView.findViewById(R.id.list1);
            listItems = getListItems();
            listViewAdapter = new ListViewAdapter_healthcolumn(this.getContext(), listItems); //创建适配器
            listView.setAdapter(listViewAdapter);
            setListViewHeightBasedOnChildren(listView);
            listView.setFocusable(false);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent it = new Intent();
                    it.setClass(getActivity(), News_detail.class);
                    it.putExtra("title", listItems.get(position).get("title1").toString());//给intent添加额外数据，key为“str”,key值为"Intent Demo"
                    it.putExtra("source", listItems.get(position).get("title2").toString());
//                it.putExtra("content",adDomain.getTopic() );
//                it.putExtra("date",adDomain.getDate() );
//                it.putExtra("img",listItems.get(position).get("img").toString());
                    startActivity(it);
                }
            });

//        new Thread(new Runnable() {
//
//            public void run() {
//                Operaton operaton = new Operaton();
//                String category = 1 + "";
//                String result = operaton.loading("NewsServlet", category);
//                List<News> list = JsonUtil.StringFromJson(result);
////                    for(int i=0;i<list.size();i++) {
////
////                        photo[i]=list.get(i).getPhoto();
////                        String url = "http://60.205.182.144:8080/shiweitian3/images/" + photo[i];
////                        try {
////                            imge[i] = getBitmap(url);list.get(i).setImg(imge[i]);
////                        } catch (Exception e) {
////
////                        }
////                    }
//
//                ArrayList<News> newlist=new ArrayList<>();
//
////                for(int i=0;i<list.size();i++){
////                    newlist.add(list.get(i));
////                }
////                Message msg=new Message();
////                User helper=new User();
////                helper.setTemp_list(newlist);
////                helper.setIsget_templist(true);
////                msg.obj=helper;
////                handler.sendMessage(msg);
//            }
//        }).start();


            return rootView;
        }
    }
//    Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            User help=(User) msg.obj;
//            ArrayList<News> temp=help.getTemp_list();
//
//            for(int i=0;i<help.getTemp_list().size();i++){
////                title1[i]=help.getTemp_list().get(i).getTitle();
////                title2[i]=help.getTemp_list().get(i).getSource();
////                date[i]=help.getTemp_list().get(i).getTime();
////                photo[i]= help.getTemp_list().get(i).getPhoto();
//////                imge[i]=help.getTemp_list().get(i).getImg();;
//
//            }
//
//            listItems = getListItems();
//            listViewAdapter = new ListViewAdapter_healthcolumn(getContext(), listItems); //创建适配器
//            listView.setAdapter(listViewAdapter);
//            setListViewHeightBasedOnChildren(listView);
//            listView.setFocusable(false);
//
//            super.handleMessage(msg);
//        }
//    };

    /**
     * 初始化商品信息
     */
    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < title1.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("title1", title1[i]);
            map.put("title2", title2[i]);
            map.put("image", imgeIDs[i]);
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
    //判断网络是否连接
    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }


}
