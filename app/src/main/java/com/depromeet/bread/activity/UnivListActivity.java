package com.depromeet.bread.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.depromeet.bread.R;

import java.util.ArrayList;

public class UnivListActivity extends AppCompatActivity {

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

    }
    private void initData() {
        String[] items = getResources().getStringArray(R.array.univ_list);
        for(String s : items) { uAdapter.add(s); }
    }


}

