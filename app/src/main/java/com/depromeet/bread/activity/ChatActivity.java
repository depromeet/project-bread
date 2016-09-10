package com.depromeet.bread.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.depromeet.bread.R;

public class ChatActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_main);

        TextView room = (TextView)findViewById(R.id.room);

        SharedPreferences sf = getSharedPreferences("pref", 0);
        String univ = sf.getString("univ", "");
        String major = sf.getString("major", "");
        room.setText(univ + " " + major);

    }


}
