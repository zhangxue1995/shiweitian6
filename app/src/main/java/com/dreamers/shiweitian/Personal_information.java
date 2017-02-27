package com.dreamers.shiweitian;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamers.shiweitian.Home_page.MainActivity;
import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.News_page.Foodmonitoringnews;
import com.dreamers.shiweitian.News_page.News;
import com.dreamers.shiweitian.News_page.News_detail_withoutimg;
import com.dreamers.shiweitian.QandA_page.Myanswer;
import com.dreamers.shiweitian.QandA_page.Myquestion;
import com.dreamers.shiweitian.Report_page.Completed;
import com.dreamers.shiweitian.Report_page.Feedback;
import com.dreamers.shiweitian.Report_page.Feedback_detail;
import com.dreamers.shiweitian.Report_page.Handled;
import com.dreamers.shiweitian.Report_page.Myreport;
import com.dreamers.shiweitian.Report_page.Submited;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stzha on 2017/1/11.
 */

public class Personal_information extends AppCompatActivity {
    public static Personal_information personal_information = null;

    private CircleImageView user_photo;private Bitmap image;String imageFilePath;
    // 声明ListView控件
    private ListView mListView;
    // 声明数组链表，其装载的类型是ListItem(封装了一个Drawable和一个String的类)
    private ArrayList<Personal_information.ListItem> mList;

    private User user;
    private TextView all_report;
    private ImageView submited,handled,completed;
    private TextView name;
    private String username,account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setTheme(R.style.AppBarTheme);
        setContentView(R.layout.personal_information);final
        User user=(User)getApplication();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#FF4CAF50"));//设置状态栏颜色
        if(Build.VERSION.SDK_INT>=21){
            getSupportActionBar().setElevation(0);
        }
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("             个人信息");

        all_report=(TextView)this.findViewById(R.id.all_report);
        all_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent();
                it.setClass(Personal_information.this, Myreport.class);
                startActivity(it);
            }
        });

        submited=(ImageView)this.findViewById(R.id.submited);
        handled=(ImageView)this.findViewById(R.id.handled);
        completed=(ImageView)this.findViewById(R.id.completed);

        submited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent();
                it.setClass(Personal_information.this,Submited.class);
                startActivity(it);
            }
        });
        handled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent();
                it.setClass(Personal_information.this,Handled.class);
                startActivity(it);
            }
        });
        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent();
                it.setClass(Personal_information.this,Completed.class);
                startActivity(it);
            }
        });


        user_photo=(CircleImageView)this.findViewById(R.id.circleimageview);
        user_photo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //如果已经登录，则更换头像；否则，登录
                if (user.isLogin()){
                    LayoutInflater in = LayoutInflater.from(getBaseContext());
                    View view = in.inflate(R.layout.photo_select, null);

                    new AlertDialog.Builder(Personal_information.this)
                            .setTitle("头像选择")
                            .setView(view)
                            .setNegativeButton("取消", null)
                            .show();
                    ImageView paizhao=(ImageView)view.findViewById(R.id.paizhao);
                    paizhao.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {
//						 TODO Auto-generated method stub

                            imageFilePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/filename.jpg";
                            File temp = new File(imageFilePath);
                            Uri imageFileUri = Uri.fromFile(temp);//获取文件的Uri
                            Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//跳转到相机Activity
                            it.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageFileUri);//告诉相机拍摄完毕输出图片到指定的Uri
                            startActivityForResult(it, 102);
                        }
                    });

                    ImageView tupianku=(ImageView)view.findViewById(R.id.tupianku);
                    tupianku.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub
                            Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            // 如果朋友们要限制上传到服务器的图片类型时可以直接写如：image/jpeg 、 image/png等的类型
//			            pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, image/png);
                            startActivityForResult(pickIntent,2);

                        }
                    });


                }
                else{
                    Intent it =new Intent();
                    it.setClass(Personal_information.this, Login_page.class);
                    startActivityForResult(it,3);
                }



            }

        });

// 通过findviewByID获取到ListView对象
        mListView=(ListView)findViewById(R.id.personal_information_list);
        // 获取Resources对象
        Resources res = this.getResources();
        mList = new ArrayList<Personal_information.ListItem>();
        // 初始化data，装载八组数据到数组链表mList中
        Personal_information.ListItem item = new Personal_information.ListItem();
        item.setImage(res.getDrawable(R.drawable.myquestion));
        item.setTitle("我的提问");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.myanswer));
        item.setTitle("我的回答");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.mynews));
        item.setTitle("我的消息");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.signout));
        item.setTitle("退出登录");
        mList.add(item);

        // 获取MainListAdapter对象
        Personal_information.MainListViewAdapter adapter = new Personal_information.MainListViewAdapter();
        // 将MainListAdapter对象传递给ListView视图
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mList.get(position).getTitle().equals("我的提问")){
                    Intent it =new Intent();
                    it.setClass(Personal_information.this, Myquestion.class);
                    startActivity(it);
                }
                if(mList.get(position).getTitle().equals("我的回答")){
                    Intent it =new Intent();
                    it.setClass(Personal_information.this, Myanswer.class);
                    startActivity(it);
                }
                if(mList.get(position).getTitle().equals("我的消息")){
                    Intent it =new Intent();
                    it.setClass(Personal_information.this, Mynews.class);
                    startActivity(it);
                }
                if(mList.get(position).getTitle().equals("退出登录")){
                    user.setLogin(false);
                    name.setText("请登录");
                    Toast.makeText(Personal_information.this,"退出成功",Toast.LENGTH_LONG).show();
                }
            }
        });

        name=(TextView)this.findViewById(R.id.name);
        if(user.isLogin()==true){
            new Thread(new Runnable() {

                public void run() {
                    Operaton operaton=new Operaton();
                    String result=operaton.userInfo("UserServlet", user.getAccount());
                    List<UserInfo> list= JsonUtil.StringFromJson1(result);

                    ArrayList<UserInfo> newlist=new ArrayList<>();

                    for(int i=0;i<list.size();i++){
                        newlist.add(list.get(i));
                    }
                    Message msg=new Message();
                    User helper=new User();
                    helper.setTemp_list1(newlist);
                    helper.setIsget_templist(true);
                    msg.obj=helper;
                    handler.sendMessage(msg);

                }
            }).start();
        }

    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            User help=(User) msg.obj;
            ArrayList<UserInfo> temp=help.getTemp_list1();

            for(int i=0;i<help.getTemp_list1().size();i++){
                username=help.getTemp_list1().get(i).getName();

            }

            name.setText(username);

            super.handleMessage(msg);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("strResult", name.getText().toString());
                intent.putExtra("bundle2", bundle);
                setResult(0, intent);
                Personal_information.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == RESULT_OK) {  //返回成功
            switch (requestCode) {
                case 102:  {//拍照获取图片
                    String status = Environment.getExternalStorageState();
                    if (resultCode == Activity.RESULT_OK) {

                        Bitmap bmp = BitmapFactory.decodeFile(imageFilePath);
                        user_photo.setImageBitmap(bmp);

                    }
                    break;
                }

                case 2:  {//相册获取图片
                    String status = Environment.getExternalStorageState();
                    if (resultCode == RESULT_OK && null != data) {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = { MediaStore.Images.Media.DATA };

                        Cursor cursor = getContentResolver().query(selectedImage,
                                filePathColumn, null, null, null);
                        cursor.moveToFirst();

                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        String picturePath = cursor.getString(columnIndex);
                        cursor.close();

                        user_photo.setImageBitmap(BitmapFactory.decodeFile(picturePath));

                    }
                    break;
                }

                case 3: {//从Personal_information返回
                    Toast.makeText(getApplication(), "LLL", Toast.LENGTH_LONG).show();
                    if (user.isLogin() == true) {
                        new Thread(new Runnable() {

                            public void run() {
                                Operaton operaton = new Operaton();
                                String result = operaton.userInfo("UserServlet", user.getAccount());
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
                        break;
                    }
                }
            }

        }
        if(resultCode == 0) {  //返回成功
            switch (requestCode) {
                case 3: {//从Personal_information返回
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


    /**
     * 定义ListView适配器MainListViewAdapter
     */
    class MainListViewAdapter extends BaseAdapter {

        /**
         * 返回item的个数
         */
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mList.size();
        }

        /**
         * 返回item的内容
         */
        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return mList.get(position);
        }

        /**
         * 返回item的id
         */
        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        /**
         * 返回item的视图
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Personal_information.ListItemView listItemView;

            // 初始化item view
            if (convertView == null) {
                // 通过LayoutInflater将xml中定义的视图实例化到一个View中
                convertView = LayoutInflater.from(Personal_information.this).inflate(
                        R.layout.items, null);

                // 实例化一个封装类ListItemView，并实例化它的两个域
                listItemView = new Personal_information.ListItemView();
                listItemView.imageView = (ImageView) convertView
                        .findViewById(R.id.image);
                listItemView.textView = (TextView) convertView
                        .findViewById(R.id.title);

                // 将ListItemView对象传递给convertView
                convertView.setTag(listItemView);
            } else {
                // 从converView中获取ListItemView对象
                listItemView = (Personal_information.ListItemView) convertView.getTag();
            }
            // 获取到mList中指定索引位置的资源
            Drawable img = mList.get(position).getImage();
            String title = mList.get(position).getTitle();

            // 将资源传递给ListItemView的两个域对象
            listItemView.imageView.setImageDrawable(img);
            listItemView.textView.setText(title);
            // 返回convertView对象
            return convertView;
        }

    }
    /**
     * 封装两个视图组件的类
     */
    class ListItemView {
        ImageView imageView;
        TextView textView;
    }
    /**
     * 封装了两个资源的类
     */
    class ListItem {
        private Drawable image;
        private String title;
        public Drawable getImage() {
            return image;
        }
        public void setImage(Drawable image) {
            this.image = image;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
    }


}


