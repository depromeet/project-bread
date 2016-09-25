package com.depromeet.bread.chat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.depromeet.bread.R;

public class ChatActivity extends AppCompatActivity  {

    ListView listView;
    MyAdapter mAdapter;
    EditText inputText;
    DrawerLayout mDrawerLayout;
    TextView room;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "한번 더 누르시면 꽈배기가 종료됩니다.", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_main);
        //mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new MyAdapter(this);
        listView.setAdapter(mAdapter);

        //채팅방명 설정
        Intent intent = getIntent();
        String roomName = intent.getExtras().getString("roomName");
        room = (TextView)findViewById(R.id.room);
        room.setText(roomName);

        //메시지보내기
        inputText = (EditText)findViewById(R.id.inputText);
        Button sendBtn = (Button)findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String text = inputText.getText().toString();
                ItemData item = new ItemData(text);

                if(text != null && !text.equals("")){
                    mAdapter.add(item);
                    listView.smoothScrollToPosition(mAdapter.getCount()-1);
                    inputText.setText("");
                }
            }
        });










    }

}


