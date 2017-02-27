package com.dreamers.shiweitian.QandA_page;

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
import android.widget.RelativeLayout;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.R;

import java.io.File;

/**
 * Created by stzha on 2017/1/9.
 */

public class Question extends AppCompatActivity{

    private Button submit;
    private RelativeLayout upload_img;
    private EditText editText1,editText2,editText3;
    private String imageFilePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

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
        actionBar.setTitle("             我要提问");

        submit=(Button)this.findViewById(R.id.submit);


        editText1=(EditText)this.findViewById(R.id.editText1);
        editText2=(EditText)this.findViewById(R.id.editText2);
        editText3=(EditText)this.findViewById(R.id.editText3);
        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);
        editText3.addTextChangedListener(textWatcher);


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
            if(editText1.getText().toString().trim().length()>0&&editText2.getText().toString().trim().length()>0&&editText3.getText().toString().trim().length()>0) {
                submit.setBackgroundColor(Color.parseColor("#FF4CAF50"));
            }
            else
                submit.setBackgroundColor(Color.parseColor("#aab3b3b3"));


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
                Question.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

