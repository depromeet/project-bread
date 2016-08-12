package com.depromeet.bread.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.depromeet.bread.R;

public class UnivSelectActivity extends AppCompatActivity {

    ImageButton univBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.univ_select);



        //대학 선택 버튼
        univBtn = (ImageButton) findViewById(R.id.univBtn);
        univBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ){


            }
        });
    }
}

