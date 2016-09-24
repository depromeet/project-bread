package com.depromeet.bread.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.depromeet.bread.R;
import com.depromeet.bread.chat.ChatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by 권윤환 on 2016-09-03.
 */
public class IndividualActivity extends AppCompatActivity {

    Button univBtn;
    Button nextBtn8;
    ImageButton add_profile_pic;
    private final int SELECT_PHOTO = 1;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4individual_info);

        univBtn = (Button)findViewById(R.id.univBtn7);
        nextBtn8 = (Button)findViewById(R.id.nextBtn8);
        add_profile_pic = (ImageButton)findViewById(R.id.add_profile_pic);

        SharedPreferences sf = getSharedPreferences("pref", 0);
        if( sf.getString("univ", "") != null){

            String univ = sf.getString("univ", "");
            String major = sf.getString("major", "");
            univBtn.setText(univ + " " + major);
        }

        //프로필 이미지 설정
        add_profile_pic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }


        });




        univBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        MajorListActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다



            }
        });

        nextBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        ChatActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
                finish();

            }
        });
    }

    //profile image pick
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        add_profile_pic.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
        }
    }

}
/*
SharedPreferences sf = getSharedPreferences(sfName, 0);
        String str = sf.getString("name", ""); // 키값으로 꺼냄
        et.setText(str);
 */