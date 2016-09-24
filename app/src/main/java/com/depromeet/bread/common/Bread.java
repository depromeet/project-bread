package com.depromeet.bread.common;

import com.depromeet.bread.common.repo.School;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Bread {

    @GET("/brd/api/getSchoolList.php")
    Call<List<School>> getSchoolList();

}
