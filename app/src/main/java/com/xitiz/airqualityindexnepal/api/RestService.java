package com.xitiz.airqualityindexnepal.api;

import com.xitiz.airqualityindexnepal.db.entity.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestService {

    @GET("/search/")
    Call<SearchResponse> getSearchResponse(@Query("token") String token, @Query("keyword") String keyword);
}
