package com.example.yf.login_mvp.login.model;

/**
 * Created by YF on 2016/5/27.
 */
public class UserModel implements IUser {
    String username;
    String password;

    public UserModel(String username , String password){
        this.username = username;
        this.password = password;
    }
    @Override
    public String getName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int checkUserValidity(String username, String password) {
        if (username == null || password == null || !username.equals(getName()) || !password.equals(getPassword())){
            return -1;
        }
        return 0;
    }
}
