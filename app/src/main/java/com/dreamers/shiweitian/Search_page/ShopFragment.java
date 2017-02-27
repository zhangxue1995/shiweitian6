package com.dreamers.shiweitian.Search_page;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.Report_page.ListViewAdapter_nearby;
import com.dreamers.shiweitian.Report_page.Report_merchant;
import com.dreamers.shiweitian.Report_page.Report_merchant_detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {
    private ListView listView;
    private ListViewAdapter_nearby listViewAdapter;
    private List<Map<String, Object>> listItems;
    private String[] title1 = {"歪卖厨房", "澳克士欢乐餐厅&送进宿舍","十里香手撕鸭","福宇记黄焖鸡米饭","美粥柒天海鲜粥馆（海岸城旗舰店）"};
    private String[] title2 = {"星光广场1楼175-1023",
            "融绿星光广场2楼",
            "雪浪板桥镇商品房内",
            "星光广场",
            "无锡市滨湖区海岸城53-117-119"};
    private String[] title3 = {"800m", "600m", "540m", "300m", "100m"};
    private Integer[] imgeIDs = {R.drawable.merchant1,
            R.drawable.merchant2, R.drawable.merchant3,
            R.drawable.merchant4, R.drawable.merchant5};


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.search_shop,container,false);
        listView = (ListView)rootView.findViewById(R.id.listView1);
        listItems = getListItems();
        listViewAdapter = new ListViewAdapter_nearby(this.getContext(), listItems); //创建适配器
        listView.setAdapter(listViewAdapter);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                listItems.get(position).get("title2");

                Intent it =new Intent();
                it.setClass(getActivity(), ShopFragment_detail.class);
                it.putExtra("name",listItems.get(position).get("title1").toString() );//给intent添加额外数据，key为“str”,key值为"Intent Demo"
                it.putExtra("address",listItems.get(position).get("title2").toString() );
                startActivity(it);
            }
        });
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
            map.put("title3", title3[i]);                 //物品名称
            listItems.add(map);
        }
        return listItems;
    }


}
