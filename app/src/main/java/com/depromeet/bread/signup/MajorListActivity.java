package com.depromeet.bread.signup;

import android.app.ProgressDialog;
import android.content.Intent;
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


/**
 * Created by 권윤환 on 2016-09-01.
 */
public class MajorListActivity extends AppCompatActivity {
    EditText univEdit;
    ListView majorList;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrUid;
    ArrayList<String> arrName;
    ArrayList<String> filteredUid;
    ArrayList<String> filteredName;
    List<School> Schools;
    String selectedUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5major_list);

        arrUid = new ArrayList<>();
        arrName = new ArrayList<>();
        filteredUid = new ArrayList<>();
        filteredName = new ArrayList<>();
        selectedUid = "";

        //데이터를 보여줄 ListView
        majorList = (ListView) findViewById(R.id.majorList);
        getSchools();

        final Intent intent = new Intent(getApplicationContext(), MajorList2Activity.class);


        //누르면 EDITTEXT로
        majorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemUid = filteredUid.get(position);
                String itemName = filteredName.get(position);

                //uid를 학과 액티비티를 넘긴다.
                selectedUid = itemUid;
                intent.putExtra("uid", itemUid);
                intent.putExtra("uName", itemName);
                univEdit.setText(itemName);
            }
        });

        //검색기능
        univEdit = (EditText) findViewById(R.id.univEdit);
        univEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int i, int i1, int i2) {
                filteredUid.clear();
                filteredName.clear();
                for (int c=0; c<arrUid.size(); c++) {
                    if (arrName.get(c).replace(" ", "").contains(cs.toString().replace(" ", ""))) {
                        filteredUid.add(arrUid.get(c));
                        filteredName.add(arrName.get(c));
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // 다음 화면으로 넘어간다
        Button nextBtn2 = (Button)findViewById(R.id.nextBtn2);
        nextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!selectedUid.isEmpty()) {
                    startActivity(intent); // 다음 화면으로 넘어간다
                    finish();
                }
                else Toast.makeText(getApplicationContext(),R.string.invalid_param, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void getSchools() {

        final ProgressDialog loading = ProgressDialog.show(this, "대학 목록을 가져오는 중입니다.",
                "잠시만 기다려주세요 :-)", false, false);

        //api 인터페이스 객체
        Call<List<School>> call = Global.bread.getSchoolList();
        call.enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                loading.dismiss(); //로딩바죽이기
                Schools = response.body(); // 뭐지? 데이터를 저장한다.

                for (int i = 0; i < Schools.size(); i++) {
                    arrUid.add(Schools.get(i).uid);
                    arrName.add(Schools.get(i).name);
                }
                filteredUid.addAll(arrUid);
                filteredName.addAll(arrName);

                adapter = new ArrayAdapter<>(MajorListActivity.this, android.R.layout.simple_list_item_1, filteredName);
                majorList.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.v("123", t.getMessage());
            }
        });

    }
}
