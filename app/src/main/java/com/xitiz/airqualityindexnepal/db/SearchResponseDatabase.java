package com.xitiz.airqualityindexnepal.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.xitiz.airqualityindexnepal.db.convertors.DataItemTypeConverter;
import com.xitiz.airqualityindexnepal.db.convertors.GeoTypeConvertor;
import com.xitiz.airqualityindexnepal.db.convertors.StationTypeConverter;
import com.xitiz.airqualityindexnepal.db.convertors.TimeTypeConverter;
import com.xitiz.airqualityindexnepal.db.entity.DataItem;
import com.xitiz.airqualityindexnepal.db.entity.SearchResponse;
import com.xitiz.airqualityindexnepal.db.entity.Station;
import com.xitiz.airqualityindexnepal.db.entity.Time;

@Database(entities = {SearchResponse.class, DataItem.class, Station.class, Time.class}, version = 1, exportSchema = false)
@TypeConverters({DataItemTypeConverter.class, StationTypeConverter.class, GeoTypeConvertor.class, TimeTypeConverter.class})
public abstract class SearchResponseDatabase extends RoomDatabase {
    public abstract SearchResponseDao searchResponseDao();

    static private volatile SearchResponseDatabase INSTANCE;

    public static SearchResponseDatabase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            synchronized (SearchResponseDatabase.class) {
                if (INSTANCE == null)
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), SearchResponseDatabase.class, "search_response_db")
                            .build();
            }
        }
        return INSTANCE;
    }

}
