package com.xitiz.airqualityindexnepal_aqin;

import com.xitiz.airqualityindexnepal_aqin.model.SearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestService {
    @GET("/search/")
    Observable<SearchResponse> getSearchResponse(@Query("token") String token, @Query("keyword") String keyword);
}
