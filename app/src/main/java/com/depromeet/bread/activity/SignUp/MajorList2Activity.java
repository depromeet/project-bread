package com.depromeet.bread.activity.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.depromeet.bread.R;

import java.util.ArrayList;

/**
 * Created by 권윤환 on 2016-09-01.
 */
public class MajorList2Activity extends AppCompatActivity {

    ListView univList;
    ArrayAdapter<String> uAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6major_list2);

        univList = (ListView) findViewById(R.id.majorList);
        uAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>());
        univList.setAdapter(uAdapter);
        //initData();

        Button nextBtn2 = (Button)findViewById(R.id.nextBtn2);
        nextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        IndividualActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });



    }
    private void initData() {
        String[] items = getResources().getStringArray(R.array.major_list);
        for(String s : items) { uAdapter.add(s); }
    }
}
