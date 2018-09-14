package com.xitiz.airqualityindexnepal.db.convertors;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xitiz.airqualityindexnepal.db.entity.Time;

import java.lang.reflect.Type;

public class TimeTypeConverter {
    @TypeConverter // note this annotation
    public static String fromOptionValuesList(Time optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Time>() {
        }.getType();
        return gson.toJson(optionValues, type);
    }

    @TypeConverter // note this annotation
    public static Time toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Time>() {
        }.getType();
        return gson.fromJson(optionValuesString, type);
    }
}
