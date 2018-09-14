package com.xitiz.airqualityindexnepal.db.convertors;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xitiz.airqualityindexnepal.db.entity.Station;

import java.lang.reflect.Type;

public class StationTypeConverter {
    @TypeConverter // note this annotation
    public static String fromOptionValuesList(Station optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Station>() {
        }.getType();
        return gson.toJson(optionValues, type);
    }

    @TypeConverter // note this annotation
    public static Station toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Station>() {
        }.getType();
        return gson.fromJson(optionValuesString, type);
    }
}
