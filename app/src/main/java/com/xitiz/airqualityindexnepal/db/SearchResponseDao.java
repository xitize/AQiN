package com.xitiz.airqualityindexnepal.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.xitiz.airqualityindexnepal.db.entity.SearchResponse;


@Dao
public interface SearchResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void savedSearchResponseToDB(SearchResponse searchResponse);

    @Query("SELECT * FROM SearchResponse")
    LiveData<SearchResponse> loadSearchResponseFromDB();

}
