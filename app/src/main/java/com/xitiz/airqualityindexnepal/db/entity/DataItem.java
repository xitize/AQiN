package com.xitiz.airqualityindexnepal.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.xitiz.airqualityindexnepal.db.convertors.StationTypeConverter;
import com.xitiz.airqualityindexnepal.db.convertors.TimeTypeConverter;

@Entity
public class DataItem {

    @PrimaryKey
    @SerializedName("uid")
    private int uid;

    @SerializedName("aqi")
    private String aqi;

    @TypeConverters(StationTypeConverter.class)
    @SerializedName("station")
    private Station station;

    @TypeConverters(TimeTypeConverter.class)
    @SerializedName("time")
    private Time time;

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getAqi() {
        return aqi;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Station getStation() {
        return station;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public String toString() {
        return
                "DataItem{" +
                        "uid = '" + uid + '\'' +
                        ",aqi = '" + aqi + '\'' +
                        ",station = '" + station + '\'' +
                        ",time = '" + time + '\'' +
                        "}";
    }
}