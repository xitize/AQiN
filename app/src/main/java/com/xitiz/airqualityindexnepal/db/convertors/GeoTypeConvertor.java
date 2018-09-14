package com.xitiz.airqualityindexnepal.db.convertors;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GeoTypeConvertor {
    @TypeConverter // note this annotation
    public static String fromOptionValuesList(List<Double> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Double>>() {
        }.getType();
        return gson.toJson(optionValues, type);
    }

    @TypeConverter // note this annotation
    public static List<Double> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Double>>() {
        }.getType();
        return gson.fromJson(optionValuesString, type);
    }
}
