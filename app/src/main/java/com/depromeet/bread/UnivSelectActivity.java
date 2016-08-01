package com.depromeet.bread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


/**
 * Created by 권윤환 on 2016-07-27.
 */
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

