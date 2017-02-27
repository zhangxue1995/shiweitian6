package com.dreamers.shiweitian.Report_page;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamers.shiweitian.Home_page.MyImageView_1;
import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.Login_page;
import com.dreamers.shiweitian.Operaton;
import com.dreamers.shiweitian.Personal_information;
import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.TitleActivity;
import com.dreamers.shiweitian.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/1/9.
 */

public class Report_merchant_detail extends AppCompatActivity{

    private Button submit;
    private RelativeLayout upload_img;
    private EditText editText1,editText2;
    private String imageFilePath;
    private TextView name,address;
    private MyImageView_1 photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_merchant_detail);

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
        actionBar.setTitle("             举报商家");

        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name");
        String address1 = intent.getStringExtra("address");

        name=(TextView)this.findViewById(R.id.name);
        address=(TextView)this.findViewById(R.id.address);
        photo=(MyImageView_1)this.findViewById(R.id.img);

        name.setText(name1);
        address.setText(address1);

//        if(name.getText().equals("德芙榛仁葡萄干巧克力")){
//            photo.setImageResource(R.drawable.chocolate1);
//        }
//        if(name.getText().equals("费列罗榛果威化巧克力")){
//            photo.setImageResource(R.drawable.chocolate2);
//        }
//        if(name.getText().equals("M&M's花生牛奶巧克力")){
//            photo.setImageResource(R.drawable.chocolate3);
//        }
        if(name.getText().equals("歪卖厨房")){
            photo.setImageResource(R.drawable.merchant1);
        }
        if(name.getText().equals("澳克士欢乐餐厅&送进宿舍")){
            photo.setImageResource(R.drawable.merchant2);
        }
        if(name.getText().equals("十里香手撕鸭")){
            photo.setImageResource(R.drawable.merchant3);
        }
        if(name.getText().equals("福宇记黄焖鸡米饭")){
            photo.setImageResource(R.drawable.merchant4);
        }
        if(name.getText().equals("美粥柒天海鲜粥馆（海岸城旗舰店）")){
            photo.setImageResource(R.drawable.merchant5);
        }

        submit=(Button)this.findViewById(R.id.submit);

        upload_img=(RelativeLayout) this.findViewById(R.id.layout3);
        upload_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater in = LayoutInflater.from(getBaseContext());
                View view = in.inflate(R.layout.photo_select, null);
                new AlertDialog.Builder(Report_merchant_detail.this)
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
                        startActivityForResult(pickIntent, 2);

                    }
                });

            }
        });

        editText1=(EditText)this.findViewById(R.id.editText1);
        editText2=(EditText)this.findViewById(R.id.editText2);
        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);


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
            if(editText1.getText().toString().trim().length()>0&&editText2.getText().toString().trim().length()>0) {
                submit.setBackgroundColor(Color.parseColor("#FF4CAF50"));
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final User user=(User)getApplication();
                        if(user.isLogin()==true) {
                            new Thread(new Runnable() {

                                public void run() {
                                    Operaton operaton=new Operaton();
                                    String result=operaton.upload("ReportServlet","0" ,user.getAccount(), editText1.getText()+"//"+editText2.getText());
                                    Message msg=new Message();
                                    if (result.equals("")){
                                        result="举报成功，等待相关部门受理";
                                    }
                                    msg.obj=result;
                                    handler.sendMessage(msg);
                                }
                            }).start();
                        }
                        else {
                            Intent it =new Intent();
                            it.setClass(Report_merchant_detail.this, Login_page.class);
                            startActivityForResult(it,4);
                        }
                    }
                });
            }
            else
                submit.setBackgroundColor(Color.parseColor("#aab3b3b3"));


        }
    };
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String string=(String) msg.obj;
            Toast.makeText(Report_merchant_detail.this, string, Toast.LENGTH_LONG).show();
            editText1.setText("");
            editText2.setText("");
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == RESULT_OK) {  //返回成功
            switch (requestCode) {
                case 102:  {//拍照获取图片
                    String status = Environment.getExternalStorageState();
                    if (resultCode == Activity.RESULT_OK) {

                        Bitmap bmp = BitmapFactory.decodeFile(imageFilePath);
                        Drawable drawable =new BitmapDrawable(bmp);
                        upload_img.setBackground(drawable);

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

                        Drawable drawable =new BitmapDrawable(BitmapFactory.decodeFile(picturePath));
                        upload_img.setBackground(drawable);

                    }
                    break;
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Report_merchant_detail.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

