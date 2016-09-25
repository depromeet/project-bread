package com.depromeet.bread.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.depromeet.bread.R;

/**
 * Created by 권윤환 on 2016-09-02.
 */
public class InfoActivity extends AppCompatActivity {



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2info);
        final EditText email_edit = (EditText)findViewById(R.id.email_edit);
        final EditText pw_edit = (EditText)findViewById(R.id.pw_edit);
        Button nextBtn5 = (Button)findViewById(R.id.nextBtn5);

        //뒤로가기
        ImageButton backOfInfo = (ImageButton)findViewById(R.id.backOfInfo);
        backOfInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });


        nextBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( email_edit.getText().toString().matches("") ){
                    Toast.makeText(getApplicationContext(),"이메일을 입력해주세요",Toast.LENGTH_SHORT).show();
                } else if ( pw_edit.getText().toString().matches("") ){
                    Toast.makeText(getApplicationContext(),"비밀번호를 입력해주세요",Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(
                            getApplicationContext(), // 현재 화면의 제어권자
                            IndividualActivity.class); // 다음 넘어갈 클래스 지정
                    startActivity(intent);

                }


            }
        });

    }

}
