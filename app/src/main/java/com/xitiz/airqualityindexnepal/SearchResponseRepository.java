package com.xitiz.airqualityindexnepal;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.xitiz.airqualityindexnepal.api.RestService;
import com.xitiz.airqualityindexnepal.api.RetrofitClient;
import com.xitiz.airqualityindexnepal.db.entity.SearchResponse;
import com.xitiz.airqualityindexnepal.util.Const;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResponseRepository {

    private LiveData<SearchResponse> readSearchResponse;
    private RestService restService;


    SearchResponseRepository(Application application) {
        restService = RetrofitClient.getRetrofit().create(RestService.class);

    }

    LiveData<SearchResponse> getReadSearchResponse() {

        final MutableLiveData<SearchResponse> data = new MutableLiveData<>();

        restService.getSearchResponse(Const.token, " Nepal").enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                Log.d("TAG", response.toString());
                data.setValue(response.body());
                Log.d("TAG", "data is pulled");
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.d("TAG", "failed to load.");

            }
        });
        return data;
    }

}
