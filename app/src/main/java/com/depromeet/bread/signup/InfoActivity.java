package com.depromeet.bread.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.depromeet.bread.R;

/**
 * Created by 권윤환 on 2016-09-02.
 */
public class InfoActivity extends AppCompatActivity {



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2info);

        Button nextBtn = (Button)findViewById(R.id.nextBtn5);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "가입이 완료되었습니다.",Toast.LENGTH_SHORT ).show();

                Intent intent = new Intent(
                            getApplicationContext(), // 현재 화면의 제어권자
                            IndividualActivity.class); // 다음 넘어갈 클래스 지정
                    startActivity(intent);


            }
        });

    }

}
