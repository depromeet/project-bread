package com.depromeet.bread.signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.depromeet.bread.R;
import com.depromeet.bread.common.Global;
import com.depromeet.bread.common.repo.School;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MajorList2Activity extends AppCompatActivity {

    EditText univEdit;
    ListView majorList;
    ArrayList<String> arrUid;
    ArrayList<String> arrName;
    ArrayAdapter<String> uAdapter;
    private List<School> Schools; //data model 저장할 리스트
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6major_list2);

        arrUid = new ArrayList<>();
        arrName = new ArrayList<>();

        majorList = (ListView) findViewById(R.id.majorList);
        univEdit = (EditText) findViewById(R.id.univEdit);

        //intent받고 학과 받아오기
        final Intent intent = getIntent();

        String uid_from_school = intent.getStringExtra("uid");
        getMajorList( uid_from_school);



        majorList.setAdapter(uAdapter);

        //누르면 EDITTEXT로
        majorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                univEdit.setText((String) majorList.getAdapter().getItem(position));
                pos = position;
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

                //

                if(univEdit.getText().toString().matches("")) {

                    Toast.makeText(getApplicationContext(),"학과를 선택해주세요",Toast.LENGTH_SHORT).show();

                }else {
                    SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putString("uid", intent.getExtras().getString("uid"));
                    editor.putString("univName", intent.getExtras().getString("uName"));
                    editor.putString("majorName", Schools.get(pos).name);
                    editor.commit();
                    finish();// 다음 화면으로 넘어간다
                }
            }

        });
    }
    public void getMajorList(String uid) {

        final ProgressDialog loading = ProgressDialog.show(this, "대학 목록을 가져오는 중입니다.",
                "잠시만 기다려주세요 :-)", false, false);

        //api 인터페이스 객체
        Call<List<School>> call = Global.bread.getMajorList( uid );
        call.enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                loading.dismiss(); //로딩바죽이기
                Schools = response.body(); // 뭐지? 데이터를 저장한다.

                for (int i = 0; i < Schools.size(); i++) {
                    arrUid.add(Schools.get(i).uid);
                    arrName.add(Schools.get(i).name);
                }

                uAdapter = new ArrayAdapter<String>(MajorList2Activity.this, android.R.layout.simple_list_item_1, arrName); //그냥 this가 아니라 이름 넣어주는구나

                majorList.setAdapter(uAdapter);
            }
            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.v("123", t.getMessage());
            }
        });

    }





}
