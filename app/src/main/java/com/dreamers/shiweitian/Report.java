package com.dreamers.shiweitian;

/**
 * Created by stzha on 2017/2/25.
 */

public class Report {
    private String id;
    private String content;  //推送内容（文字）
    private String time;  //推送内容（图片）
    private String photo;      //时间
    private String state;
    private String shop;  //推送内容（文字）
    private String user;  //推送内容（图片）

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getPhoto() {
        return photo;
    }

    public String getState() {
        return state;
    }

    public String getShop() {
        return shop;
    }

    public String getUser() {
        return user;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
