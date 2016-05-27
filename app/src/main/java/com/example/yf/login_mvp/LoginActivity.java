package com.example.yf.login_mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.yf.login_mvp.presenter.ILoginPresenter;
import com.example.yf.login_mvp.presenter.LoginPresenterCompl;
import com.example.yf.login_mvp.view.ILoginView;

public class LoginActivity extends Activity implements ILoginView , View.OnClickListener{

    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button btnClear;
    private ProgressBar progressBar;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUser = (EditText) findViewById(R.id.et_login_username);
        editPass = (EditText) findViewById(R.id.et_login_password);
        btnLogin = (Button) findViewById(R.id.btn_login_login);
        btnClear = (Button) findViewById(R.id.btn_login_clear);

        progressBar = (ProgressBar) findViewById(R.id.progress_login);


        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        //init
        loginPresenter = new LoginPresenterCompl((ILoginView) this);
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_login:
                loginPresenter.setProgressBarVisibility(View.VISIBLE);
                btnLogin.setEnabled(false);
                btnClear.setEnabled(false);
                loginPresenter.doLogin(editUser.getText().toString() , editPass.getText().toString());
                break;
            case R.id.btn_login_clear:
                loginPresenter.clear();
                break;
        }
    }

    @Override
    public void onClearText() {
        editUser.setText("");
        editPass.setText("");

    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        if (result){
            Toast.makeText(this , "Login Success" , Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this , "Login Fail , code  = " + code , Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
