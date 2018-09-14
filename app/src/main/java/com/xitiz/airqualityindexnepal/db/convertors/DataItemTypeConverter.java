package com.xitiz.airqualityindexnepal.db.convertors;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xitiz.airqualityindexnepal.db.entity.DataItem;

import java.lang.reflect.Type;
import java.util.List;

public class DataItemTypeConverter {
    @TypeConverter // note this annotation
    public static String fromOptionValuesList(List<DataItem> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<DataItem>>() {
        }.getType();
        return gson.toJson(optionValues, type);
    }

    @TypeConverter // note this annotation
    public static List<DataItem> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<DataItem>>() {
        }.getType();
        return gson.fromJson(optionValuesString, type);
    }
}
