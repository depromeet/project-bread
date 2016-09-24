package com.depromeet.bread.common;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Global {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://inirin.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static Bread bread = retrofit.create(Bread.class);

}
