package com.xitiz.airqualityindexnepal.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.xitiz.airqualityindexnepal.db.convertors.GeoTypeConvertor;

import java.util.List;
@Entity
public class Station {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @TypeConverters(GeoTypeConvertor.class)
    @SerializedName("geo")
    private List<Double> geo;

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public void setGeo(List<Double> geo) {
        this.geo = geo;
    }

    public List<Double> getGeo() {
        return geo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return
                "Station{" +
                        "geo = '" + geo + '\'' +
                        ",name = '" + name + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}