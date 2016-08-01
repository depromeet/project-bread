package com.depromeet.bread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by 권윤환 on 2016-07-27.
 */
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
