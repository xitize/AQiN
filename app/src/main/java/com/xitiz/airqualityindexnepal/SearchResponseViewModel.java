package com.xitiz.airqualityindexnepal;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.xitiz.airqualityindexnepal.db.entity.SearchResponse;
import com.xitiz.airqualityindexnepal.repository.SearchResponseRepository;

public class SearchResponseViewModel extends AndroidViewModel {
    private SearchResponseRepository searchResponseRepository;

    public SearchResponseViewModel(@NonNull Application application) {
        super(application);
        searchResponseRepository = new SearchResponseRepository(application);

    }

  public   LiveData<SearchResponse> getResponseFromDB() {
        return searchResponseRepository.getFromDBSearchResponse();
    }

  public   void loadFormWebSearchResponse() {
        searchResponseRepository.getFromWebSearchResponse();
    }
}
