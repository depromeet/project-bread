package com.depromeet.bread.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.depromeet.bread.R;
import com.depromeet.bread.login.LoginActivity;
import com.depromeet.bread.login.LoginModule;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // 자동로그인 정보가 있는지 확인
        SharedPreferences sharedPref = getSharedPreferences("USER", Context.MODE_PRIVATE);
        final String email = sharedPref.getString("ID", "");
        final String passwd = sharedPref.getString("PW", "");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (email.isEmpty() || passwd.isEmpty()) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                } else {
                    LoginModule loginModule = new LoginModule(SplashActivity.this);
                    loginModule.tryLogin(email, passwd, true);
                }
            }
        }, 2000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
