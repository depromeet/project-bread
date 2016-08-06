package com.depromeet.bread.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.depromeet.bread.R;

public class UnivSelectActivity extends Activity {

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

