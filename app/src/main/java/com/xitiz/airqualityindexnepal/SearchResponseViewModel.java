package com.xitiz.airqualityindexnepal;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import com.xitiz.airqualityindexnepal.db.entity.SearchResponse;

public class SearchResponseViewModel extends AndroidViewModel {
    private LiveData<SearchResponse> readSearchResponse;

    public SearchResponseViewModel(@NonNull Application application) {
        super(application);
        SearchResponseRepository searchResponseRepository = new SearchResponseRepository(application);
        readSearchResponse = searchResponseRepository.getReadSearchResponse();

    }

   public LiveData<SearchResponse> getSearchResponse() {
        return readSearchResponse;
    }



}
