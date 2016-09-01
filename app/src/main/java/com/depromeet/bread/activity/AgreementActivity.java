package com.depromeet.bread.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.depromeet.bread.R;

/**
 * Created by 권윤환 on 2016-08-11.
 */
public class AgreementActivity extends AppCompatActivity{



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agreement);




        final RadioButton agreeBtn1 = (RadioButton)findViewById(R.id.agreeBtn1);
        final RadioButton agreeBtn2 = (RadioButton)findViewById(R.id.agreeBtn2);
        final RadioButton agreeBtn3 = (RadioButton)findViewById(R.id.agreeBtn3);

        //다음버튼
        Button nextBtn = (Button)findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( agreeBtn3.isChecked() ){
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        UnivSelectActivity.class); // 다음 넘어갈 클래스 지정
                        startActivity(intent);
                }else if ( agreeBtn1.isChecked() && agreeBtn2.isChecked() ){
                    Intent intent = new Intent(
                            getApplicationContext(), // 현재 화면의 제어권자
                            UnivSelectActivity.class); // 다음 넘어갈 클래스 지정
                    startActivity(intent); // 다음 화면으로 넘어간다
                }else {
                    Toast.makeText(getApplicationContext(), "약관에 동의해주세요",Toast.LENGTH_SHORT ).show();
                }
            }
        });

        //모두 동의하기

        agreeBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agreeBtn1.setChecked(true);
                agreeBtn2.setChecked(true);
            }
        });





    }



}
