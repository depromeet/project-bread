package com.depromeet.bread.activity.SignUp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.depromeet.bread.R;
import com.depromeet.bread.activity.ChatActivity;

/**
 * Created by 권윤환 on 2016-09-03.
 */
public class IndividualActivity extends AppCompatActivity {

    Button univBtn;
    Button nextBtn8;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4individual_info);

        univBtn = (Button)findViewById(R.id.univBtn7);
        nextBtn8 = (Button)findViewById(R.id.nextBtn8);

        SharedPreferences sf = getSharedPreferences("pref", 0);
        if( sf.getString("univ", "") != null){

            String univ = sf.getString("univ", "");
            String major = sf.getString("major", "");
            univBtn.setText(univ + " " + major);
        }




        univBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(
                            getApplicationContext(), // 현재 화면의 제어권자
                            MajorListActivity.class); // 다음 넘어갈 클래스 지정
                    startActivity(intent); // 다음 화면으로 넘어간다

            }
        });

        nextBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        ChatActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
                finish();

            }
        });
    }
}
/*
SharedPreferences sf = getSharedPreferences(sfName, 0);
        String str = sf.getString("name", ""); // 키값으로 꺼냄
        et.setText(str);
 */