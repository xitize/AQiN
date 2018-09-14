package com.xitiz.airqualityindexnepal.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.xitiz.airqualityindexnepal.util.Loc;
import com.xitiz.airqualityindexnepal.db.convertors.DataItemTypeConverter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SearchResponse {
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @TypeConverters(DataItemTypeConverter.class)
    @SerializedName("data")
    private List<DataItem> data;

    @SerializedName("status")
    private String status;

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return
                "SearchResponse{" +
                        "data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }

    /*get lists of locations in Lat Lng*/
    public List<Loc> getListOfLatLong() {
        List<Loc> locList = new ArrayList<>();
        for (DataItem dataItem : data) {

            locList.add(new Loc(dataItem.getStation().getGeo().get(0), dataItem.getStation().getGeo().get(1)));

        }
        return locList;
    }


}