package com.xitiz.airqualityindexnepal_aqin.model;

import com.google.gson.annotations.SerializedName;
import com.xitiz.airqualityindexnepal_aqin.model.DataItem;

import java.util.List;

public class SearchResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private String status;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"SearchResponse{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}