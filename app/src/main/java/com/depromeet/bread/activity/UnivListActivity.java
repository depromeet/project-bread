package com.depromeet.bread.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.depromeet.bread.R;

import java.util.ArrayList;

public class UnivListActivity extends AppCompatActivity {

    Button nextBtn;
    ListView univList;
    ArrayAdapter<String> uAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.univ_list);

        univList = (ListView) findViewById(R.id.univList);
        uAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>());
        univList.setAdapter(uAdapter);
        initData();

        //학과 선택 페이지로

        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ){
                Intent intent = new Intent(getApplicationContext(), MajorListActivity.class);
                startActivity(intent);
            }
        });

    }
    private void initData() {
        String[] items = getResources().getStringArray(R.array.univ_list);
        for(String s : items) { uAdapter.add(s); }
    }


}

