package com.example.yf.login_mvp.model;

/**
 * Created by YF on 2016/5/27.
 */
public interface IUser {
    String getName();
    String getPassword();
    int checkUserValidity(String username, String password);
}
