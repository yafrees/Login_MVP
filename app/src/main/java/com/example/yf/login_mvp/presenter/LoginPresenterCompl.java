package com.example.yf.login_mvp.presenter;

import android.os.Looper;
import android.os.Handler;
import com.example.yf.login_mvp.model.IUser;
import com.example.yf.login_mvp.model.UserModel;
import com.example.yf.login_mvp.view.ILoginView;

/**
 * Created by YF on 2016/5/27.
 */
public class LoginPresenterCompl implements ILoginPresenter {

    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String username, String password) {
        Boolean isLoginSuccess = true;
       final int code = user.checkUserValidity(username , password);
        if (code != 0)
            isLoginSuccess = false;
        final boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result , code);
            }
        } , 5000);

    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }

    private void initUser() {
        user = new UserModel("mvp" , "mvp");
    }

}
