package com.xitiz.airqualityindexnepal.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SearchResponse {

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