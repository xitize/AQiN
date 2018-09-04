package com.xitiz.airqualityindexnepal_aqin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xitiz.airqualityindexnepal_aqin.model.SearchResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public static final String token = "ab6ee2d842577dc583fcd4b3d740f52c48726718";
    RecyclerView recyclerView;


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RestService restService = RestApi.getClient().create(RestService.class);

        restService.getSearchResponse(token, " Nepal")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<SearchResponse>() {
                    @Override
                    public void onNext(SearchResponse searchResponse) {
                        Log.d("TAG", "" + searchResponse.toString());
                        recyclerView.setAdapter(new SearchAdapter(searchResponse.getData()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "error " + e.getCause());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG", "completed ");
                    }
                });
    }
}
