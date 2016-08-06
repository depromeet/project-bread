package com.depromeet.bread.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.depromeet.bread.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        final View formLogin = findViewById(R.id.form_login);
        final EditText etLoginId = (EditText) findViewById(R.id.et_login_id);
        final EditText etLoginPw = (EditText) findViewById(R.id.et_login_pw);

        // 아이디, 비밀번호 입력필드 너비 적용
        formLogin.post(new Runnable() {
            @Override
            public void run() {
                etLoginId.setWidth(etLoginId.getWidth());
                etLoginPw.setWidth(etLoginPw.getWidth());
            }
        });
    }
}
