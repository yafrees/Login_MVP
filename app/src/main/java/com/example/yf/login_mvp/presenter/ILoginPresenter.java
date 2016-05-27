package com.example.yf.login_mvp.presenter;

/**
 * Created by YF on 2016/5/27.
 */
public interface ILoginPresenter {
    void clear();
    void doLogin(String username , String password);
    void setProgressBarVisibility(int visibility);
}
