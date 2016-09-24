package com.depromeet.bread.common;

import com.depromeet.bread.common.repo.School;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Bread {

    @GET("/brd/api/getSchoolList.php")
    Call<List<School>> getSchoolList();



    @FormUrlEncoded
    @POST("/brd/api/getMajorList.php")
    Call<List<School>> getMajorList(
            @Field("uid") String uid
    );

}


