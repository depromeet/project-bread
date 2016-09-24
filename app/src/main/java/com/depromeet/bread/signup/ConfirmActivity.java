package com.depromeet.bread.signup;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.depromeet.bread.R;

/**
 * Created by 권윤환 on 2016-09-03.
 */
public class ConfirmActivity extends AppCompatActivity {

    TextView univText;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7confirm);

        univText = (TextView) findViewById (R.id.univText);
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        univText.setText(pref.getString("univ_key", "대학을 설정하세요"));

    }
}
