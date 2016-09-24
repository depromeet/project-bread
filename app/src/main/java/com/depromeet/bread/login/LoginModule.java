package com.depromeet.bread.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.depromeet.bread.R;
import com.depromeet.bread.chat.ChatActivity;
import com.depromeet.bread.common.Global;
import com.depromeet.bread.common.repo.Member;
import com.depromeet.bread.common.repo.Success;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModule {
    public Activity activity;
    public ProgressDialog loading;
    public SharedPreferences sharedPref;
    public SharedPreferences.Editor sharedEdit;

    public LoginModule(Activity activity) {
        this.activity = activity;
        loading = new ProgressDialog(activity);
        loading.setMessage("Loading. Please wait...");
        loading.setIndeterminate(true);
        loading.setCancelable(false);
        sharedPref = activity.getSharedPreferences("USER", Context.MODE_PRIVATE);
        sharedEdit = sharedPref.edit();
    }

    public void tryLogin(final String email, final String passwd, final boolean intent) {
        loading.show();

        Call<Member> call = Global.bread.login(email, passwd);
        call.enqueue(new Callback<Member>() {
            @Override
            public void onResponse(Call<Member> call, Response<Member> response) {
                Member member = response.body();

                // 로그인 성공시 디바이스 토큰 등록
                if (member.result == 1) {
                    String token = FirebaseInstanceId.getInstance().getToken();
                    updateDeviceToken(member.uid, token);
                    sharedEdit.putString("ID", email);
                    sharedEdit.putString("PW", passwd);
                }
                // 로그인 실패시 로컬정보 삭제 후 로그인 화면으로 이동
                else {
                    Toast.makeText(activity, R.string.invalid_param, Toast.LENGTH_SHORT).show();
                    if (intent) {
                        sharedEdit.clear();
                        sharedEdit.apply();
                        activity.startActivity(new Intent(activity, LoginActivity.class));
                        activity.finish();
                    }
                }
                loading.dismiss();
            }
            @Override
            public void onFailure(Call<Member> call, Throwable t) {
                Toast.makeText(activity, R.string.conn_fail, Toast.LENGTH_SHORT).show();
                loading.dismiss();
            }
        });
    }

    private void updateDeviceToken(final String uid, final String token) {

        Call<Success> call = Global.bread.updateDeviceToken(uid, token);
        call.enqueue(new Callback<Success>() {
            @Override
            public void onResponse(Call<Success> call, Response<Success> response) {
                Success body = response.body();

                // 토큰 등록 성공시 채팅창으로 이동
                if (body.result == 1) {
                    sharedEdit.apply();
                    activity.startActivity(new Intent(activity, ChatActivity.class));
                    activity.finish();
                }
                // 토큰 등록 실패시 로그인 화면으로 이동
                else {
                    Toast.makeText(activity, R.string.invalid_param, Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                    activity.startActivity(new Intent(activity, LoginActivity.class));
                    activity.finish();
                }
                loading.dismiss();
            }
            @Override
            public void onFailure(Call<Success> call, Throwable t) {
                Toast.makeText(activity, R.string.conn_fail, Toast.LENGTH_SHORT).show();
                loading.dismiss();
            }
        });
    }
}
