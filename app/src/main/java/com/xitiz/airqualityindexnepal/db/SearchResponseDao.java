package com.xitiz.airqualityindexnepal.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.xitiz.airqualityindexnepal.db.entity.SearchResponse;

import io.reactivex.Observable;


@Dao
public interface SearchResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(SearchResponse searchResponse);

    @Query("SELECT * FROM SearchResponse")
    LiveData<SearchResponse> loadSearchResponseObservable();

}
