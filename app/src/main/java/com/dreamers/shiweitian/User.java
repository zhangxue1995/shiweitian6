package com.dreamers.shiweitian;

import android.app.Application;

import com.dreamers.shiweitian.News_page.News;

import java.util.ArrayList;

/**
 * Created by stzha on 2017/1/25.
 */

public class User extends Application{
    public boolean isLogin;
    public String account;
    public String password;
    public String username;
    private ArrayList<News> temp_list;
    private ArrayList<UserInfo> temp_list1;
    private boolean isget_templist;

    public void setIsget_templist(boolean isget_templist) {
        this.isget_templist = isget_templist;
    }

    public boolean isget_templist() {

        return isget_templist;
    }

    public void setTemp_list(ArrayList<News> temp_list) {
        this.temp_list = temp_list;
    }

    public ArrayList<News> getTemp_list() {

        return temp_list;
    }

    public void setTemp_list1(ArrayList<UserInfo> temp_list) {
        this.temp_list1 = temp_list;
    }

    public ArrayList<UserInfo> getTemp_list1() {

        return temp_list1;
    }

    @Override
    public void onCreate(){
        isLogin=false;
        super.onCreate();
    }

    public boolean isLogin() {
        return isLogin;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
