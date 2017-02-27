package com.dreamers.shiweitian.News_page;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.QandA_page.QandA_detail;
import com.dreamers.shiweitian.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by stzha on 2017/1/8.
 */

public class Foodmonitoringnews extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter_foodmonitoringnews listViewAdapter;
    private List<Map<String, Object>> listItems;
    private String[] title1 = {"习近平对食品安全工作作出重要指示强调", "无锡局食品生产许可工作获全省第二名",
            "锡山区市场监管局全面完成药品零售企业医疗机构药品质量安全信用等级评定工作",
            "无锡局四举措强化保健食品抽检工作","无锡市食品生产监管条线正式使用电子监管系统","无锡出台制度规范食品安全监督抽检后处理工作","无锡市春节长假食品药品安全形势平稳,未发生食品药品安全突发事件"};
    private String[] title2 = {"无锡市食品药品监督管理局", "无锡市食品药品监督管理局","无锡市食品药品监督管理局","无锡市食品药品监督管理局","无锡市食品药品监督管理局","无锡市食品药品监督管理局","无锡市食品药品监督管理局"};
    private String[] title3 = {"中共中央总书记、国家主席、中央军委主席习近平日前对食品安全工作作出重要指示指出，民以食为天，加强食品安全工作，关系我国13亿多人的身体健康和生命安全，必须抓得紧而又紧。",
            "近日，无锡局在省局食品生产监管处组织的食品生产许可工作考核中，取得了总分全省第二的优异成绩，获得了省局领导的肯定。",
            "为提高药品零售企业、医疗机构的诚信意识，加强对药品零售企业、医疗机构药品经营和使用监督管理，切实保障药品零售企业、医疗机构药品质量安全，近日，锡山区市场监督管理局按照《江苏省零售药店药品安全信用等级评价标准（试行）》、《无锡市医疗机构药品质量安全信用等级评定管理办法（暂行）》等相关要求，对全区217家药品零售企业和17家一级以上医疗机机构开展药品质量安全信用等级评定工作。",
            "无锡市局采取四项措施，扎实开展保健食品抽检及安全风险监测工作。",
            "为加强基层食品生产监管的信息化建设，有效使用信息化手段提高基层监管效率，实现食品生产监管台账的信息化、食品质量安全监管的信息化，无锡市食品生产监管条线于2017年1月1日起正式使用电子监管系统。",
            "为规范食品安全监督抽检不合格食品后处理工作，充分发挥监督抽检在食品安全监管中的作用，近日，无锡市食品药品监管局出台了《无锡市食品安全监督抽检不合格产品后处理工作程序规定》，明确了后处理、职责分工、工作程序要求等事项。",
            "2017年春节期间，无锡市食品药品监督管理局积极开展食品药品市场监督检查，严格落实值班制度，保障了春节食品药品市场安全形势平稳。"};
    private Integer[] imgeIDs = {R.drawable.chocolate1,
            R.drawable.chocolate2, R.drawable.chocolate3,
            R.drawable.chocolate4, R.drawable.chocolate5,R.drawable.blank};


    public static String IMAGE_CACHE_PATH = "imageloader/Cache"; // 图片缓存路径

    private ViewPager adViewPager;
    private List<ImageView> imageViews;// 滑动的图片集合

    private List<View> dots; // 图片标题正文的那些点
    private List<View> dotList;

    private TextView tv_topic;
    private int currentItem = 0; // 当前图片的索引号
    // 定义的五个指示点
    private View dot0;
    private View dot1;
    private View dot2;

    private ScheduledExecutorService scheduledExecutorService;

    // 异步加载图片
    private ImageLoader mImageLoader;
    private DisplayImageOptions options;

    // 轮播banner的数据
    private List<AdDomain> adList;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            adViewPager.setCurrentItem(currentItem);
        };
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodmonitoringnews_more);

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
        actionBar.setTitle("             食监新闻");

        // 使用ImageLoader之前初始化
        initImageLoader();

        // 获取图片加载实例
        mImageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.top_banner_android)
                .showImageForEmptyUri(R.drawable.top_banner_android)
                .showImageOnFail(R.drawable.top_banner_android)
                .cacheInMemory(true).cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY).build();
        initAdData();

        startAd();


        listView = (ListView)findViewById(R.id.list1);
        listItems = getListItems();
        listViewAdapter = new ListViewAdapter_foodmonitoringnews(this, listItems); //创建适配器
        listView.setAdapter(listViewAdapter);
        setListViewHeightBasedOnChildren(listView);
        listView.setFocusable(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it =new Intent();
                it.setClass(Foodmonitoringnews.this, News_detail_withoutimg.class);
                it.putExtra("title",listItems.get(position).get("title1").toString() );//给intent添加额外数据，key为“str”,key值为"Intent Demo"
                it.putExtra("source",listItems.get(position).get("title2").toString() );
                it.putExtra("content",listItems.get(position).get("title3").toString() );
                startActivity(it);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Foodmonitoringnews.this.finish(); // back button
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
            map.put("title1", title1[i]);               //图片资源
            map.put("title2", title2[i]);              //物品标题
            map.put("title3", title3[i]);     //物品名称
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



    private void initImageLoader() {
        File cacheDir = com.nostra13.universalimageloader.utils.StorageUtils
                .getOwnCacheDirectory(this.getApplicationContext(),
                        IMAGE_CACHE_PATH);

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisc(true).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                this.getApplicationContext()).defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new LruMemoryCache(12 * 1024 * 1024))
                .memoryCacheSize(12 * 1024 * 1024)
                .discCacheSize(32 * 1024 * 1024).discCacheFileCount(100)
                .discCache(new UnlimitedDiscCache(cacheDir))
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();

        ImageLoader.getInstance().init(config);
    }

    private void initAdData() {
        // 广告数据
        adList = getBannerAd();

        imageViews = new ArrayList<ImageView>();

        // 点
        dots = new ArrayList<View>();
        dotList = new ArrayList<View>();
        dot0 = this.findViewById(R.id.v_dot0);
        dot1 = this.findViewById(R.id.v_dot1);
        dot2 = this.findViewById(R.id.v_dot2);
        dots.add(dot0);
        dots.add(dot1);
        dots.add(dot2);

        tv_topic = (TextView) this.findViewById(R.id.tv_topic);

        adViewPager = (ViewPager) this.findViewById(R.id.vp);
        adViewPager.setAdapter(new Foodmonitoringnews.MyAdapter());// 设置填充ViewPager页面的适配器
        // 设置一个监听器，当ViewPager中的页面改变时调用
        adViewPager.setOnPageChangeListener(new Foodmonitoringnews.MyPageChangeListener());
        addDynamicView();


    }

    private void addDynamicView() {
        // 动态添加图片和下面指示的圆点
        // 初始化图片资源
        for (int i = 0; i < adList.size(); i++) {
            ImageView imageView = new ImageView(this.getApplicationContext());
            // 异步加载图片
            mImageLoader.displayImage(adList.get(i).getImgUrl(), imageView,
                    options);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViews.add(imageView);
            dots.get(i).setVisibility(View.VISIBLE);
            dotList.add(dots.get(i));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void startAd() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 当Activity显示出来后，每两秒切换一次图片显示
        scheduledExecutorService.scheduleAtFixedRate(new Foodmonitoringnews.ScrollTask(), 1, 2,
                TimeUnit.SECONDS);
    }

    private class ScrollTask implements Runnable {

        @Override
        public void run() {
            synchronized (adViewPager) {
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget();
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // 当Activity不可见的时候停止切换
        scheduledExecutorService.shutdown();
    }

    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        private int oldPosition = 0;

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            currentItem = position;
            AdDomain adDomain = adList.get(position);
            tv_topic.setText(adDomain.getTopic());
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return adList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = imageViews.get(position);
            ((ViewPager) container).addView(iv);
            final AdDomain adDomain = adList.get(position);
            // 在这个方法里面设置图片的点击事件
            iv.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 处理跳转逻辑
                    Intent it =new Intent();
                    it.setClass(Foodmonitoringnews.this, News_detail.class);
                    it.putExtra("title",adDomain.getTopic() );//给intent添加额外数据，key为“str”,key值为"Intent Demo"
                    it.putExtra("source",adDomain.getTopicFrom() );
                    it.putExtra("content",adDomain.getTopic() );
                    it.putExtra("date",adDomain.getDate() );
                    it.putExtra("img",adDomain.getImgUrl());
                    startActivity(it);
                }
            });
            return iv;
        }


        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }

    }

    /**
     * 轮播广播模拟数据
     *
     * @return
     */
    public static List<AdDomain> getBannerAd() {
        List<AdDomain> adList = new ArrayList<AdDomain>();

        AdDomain adDomain = new AdDomain();
        adDomain.setId("108078");
        adDomain.setDate("12月24日");
        adDomain.setTitle("中国茶文化知识大全");
        adDomain.setTopicFrom("无锡市食品药品监督管理局");
        adDomain.setTopic("无锡市食品安全快速检测实验中心建成");
        adDomain.setImgUrl("http://60.205.182.144:8080/shiweitian3/images/foodmonitor_1.jpg");
        adDomain.setAd(false);
        adList.add(adDomain);

        AdDomain adDomain2 = new AdDomain();
        adDomain2.setId("108078");
        adDomain2.setDate("3月5日");
        adDomain2.setTitle("五谷杂粮");
        adDomain2.setTopicFrom("无锡市食品药品监督管理局");
        adDomain2.setTopic("多措并举保障“两会”餐饮食品安全");
        adDomain2
                .setImgUrl("http://60.205.182.144:8080/shiweitian3/images/foodmonitor_2.jpg");
        adDomain2.setAd(false);
        adList.add(adDomain2);

        AdDomain adDomain3 = new AdDomain();
        adDomain3.setId("108078");
        adDomain3.setDate("3月6日");
        adDomain3.setTitle("啦啦啦啦啦");
        adDomain3.setTopicFrom("无锡市食品药品监督管理局");
        adDomain3.setTopic("无锡市《食品小作坊登记证管理办法》正式实施");
        adDomain3
                .setImgUrl("http://60.205.182.144:8080/shiweitian3/images/foodmonitor_3.jpg");
        adDomain3.setAd(false);
        adList.add(adDomain3);

        return adList;
    }


}