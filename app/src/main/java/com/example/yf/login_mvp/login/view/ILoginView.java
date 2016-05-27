package com.example.yf.login_mvp.login.view;

/**
 * Created by YF on 2016/5/27.
 */
public interface ILoginView {
    public void onClearText();
    public void onLoginResult(Boolean result , int code);
    public void onSetProgressBarVisibility(int visibility);
}
