package com.xitiz.airqualityindexnepal;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.xitiz.airqualityindexnepal.api.RestService;
import com.xitiz.airqualityindexnepal.api.RetrofitClient;
import com.xitiz.airqualityindexnepal.db.SearchResponseDao;
import com.xitiz.airqualityindexnepal.db.SearchResponseDatabase;
import com.xitiz.airqualityindexnepal.db.entity.SearchResponse;
import com.xitiz.airqualityindexnepal.util.Const;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResponseRepository {

    private SearchResponseDao searchResponseDao;
    private LiveData<SearchResponse> readSearchResponse;


    SearchResponseRepository(Application application) {
        SearchResponseDatabase searchResponseDatabase = SearchResponseDatabase.getINSTANCE(application);
        RestService restService = RetrofitClient.getRetrofit().create(RestService.class);
        searchResponseDao = searchResponseDatabase.searchResponseDao();

        restService.getSearchResponse(Const.token, " Nepal").enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                assert response.body() != null;
                Log.d("TAG", "" + response.body().toString());
                SearchResponse searchResponse = response.body();
                //savedSearchResponseToDB the searchResponse
                new AsyncSave(searchResponseDao).execute(searchResponse);

            }

            @Override
            public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                Log.d("TAG", "failed to load " + t.getMessage());
            }
        });
        readSearchResponse = searchResponseDao.loadSearchResponseFromDB();

    }

    LiveData<SearchResponse> getReadSearchResponse() {
        return readSearchResponse;
    }

    private static class AsyncSave extends AsyncTask<SearchResponse, Void, Void> {
        SearchResponseDao searchResponseDao;

        AsyncSave(SearchResponseDao searchResponse) {
            this.searchResponseDao = searchResponse;
        }

        @Override
        protected Void doInBackground(SearchResponse... searchResponses) {
            searchResponseDao.savedSearchResponseToDB(searchResponses[0]);
            Log.d("TAG", "response saved to DB");
            return null;
        }
    }
}
