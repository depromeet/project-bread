package com.depromeet.bread.activity.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 권윤환 on 2016-09-23.
 */
public interface SchoolAPI {

    @GET("/brd/api/getSchoolList.php")
    Call<List<School>> getSchools();
    //public void getSchools(Callback<List<School>> response); retrofit1.9





}
