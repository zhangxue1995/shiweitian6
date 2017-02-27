package com.dreamers.shiweitian;

import android.graphics.Bitmap;

/**
 * Created by stzha on 2017/2/19.
 */

public class UserInfo {
    private String id;
    private String password;  //推送内容（文字）
    private String name;  //推送内容（图片）
    private String photo;      //时间

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
