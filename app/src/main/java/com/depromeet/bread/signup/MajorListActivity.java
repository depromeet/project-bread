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

import com.depromeet.bread.R;
import com.depromeet.bread.common.Global;
import com.depromeet.bread.common.repo.School;

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
    ArrayAdapter<String> uAdapter;
    private List<School> Schools; //data model 저장할 리스트
    //API 통신
    public static final String ROOT_URL = "http://inirin.com/";
    public static final String KEY_UID = "key_u_id";
    public static final String KEY_UNAME = "key_u_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5major_list);

        //데이터를 보여줄 ListView
        majorList = (ListView) findViewById(R.id.majorList);
        getSchools(); //calling method that will fetch data


        //HARD CODING
        /*String products[] = { "동국대학교", "서울대학교", "연세대학교", "상명대학교", "광운대학교",
                "고려대학교", "홍익대학교", "울산대학교", "이화여자대학교", "Dongguk university",
                "Seoul university", "Hongik university", "Yonsei University"};

        univEdit = (EditText) findViewById(R.id.univEdit);

        uAdapter = new ArrayAdapter<>(this, R.layout.univ_list_item,R.id.item_name,products);
        majorList.setAdapter(uAdapter);*/

        //누르면 EDITTEXT로
        majorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                univEdit.setText((String) majorList.getAdapter().getItem(position));
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
                MajorListActivity.this.uAdapter.getFilter().filter(cs);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        Button nextBtn2 = (Button)findViewById(R.id.nextBtn2);
        nextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                savePreferences();
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        MajorList2Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });


    }
    private void savePreferences() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("univ", univEdit.getText().toString());
        editor.commit();
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

                String[] items = new String[Schools.size()]; //대학이름을 담을 스트링 어레이
                for (int i = 0; i < Schools.size(); i++) {
                    items[i] = Schools.get(i).name.toString();
                }

                uAdapter = new ArrayAdapter<String>(MajorListActivity.this, android.R.layout.simple_list_item_1, items); //그냥 this가 아니라 이름 넣어주는구나

                majorList.setAdapter(uAdapter);
            }
            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.v("123", t.getMessage());
            }
        });

    }
}
