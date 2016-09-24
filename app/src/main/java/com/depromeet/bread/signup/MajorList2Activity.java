package com.depromeet.bread.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.depromeet.bread.R;

public class MajorList2Activity extends AppCompatActivity {

    EditText univEdit;
    ListView majorList;
    ArrayAdapter<String> uAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6major_list2);

        String products[] = {"경영학과", "컴퓨터공학과", "교육학과", "국문학과", "의류학과", "콘텐츠디자인학과"};
        majorList = (ListView) findViewById(R.id.majorList);
        univEdit = (EditText) findViewById(R.id.univEdit);

        uAdapter = new ArrayAdapter<>(this, R.layout.univ_list_item, R.id.item_name, products);
        majorList.setAdapter(uAdapter);

        //누르면 EDITTEXT로
        majorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                univEdit.setText((String) majorList.getAdapter().getItem(position));
            }
        });

        //검색기능
        univEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int i, int i1, int i2) {
                MajorList2Activity.this.uAdapter.getFilter().filter(cs);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        //다음
        Button nextBtn6 = (Button) findViewById(R.id.nextBtn6);
        nextBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                savePreferences();
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        IndividualActivity.class); // 다음 넘어갈 클래스 지정
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();// 다음 화면으로 넘어간다
            }

        });
    }

    private void savePreferences() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("major", univEdit.getText().toString());
        editor.commit();
    }




}
