package com.xitiz.airqualityindexnepal.model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("uid")
	private int uid;

	@SerializedName("aqi")
	private String aqi;

	@SerializedName("station")
	private Station station;

	@SerializedName("time")
	private Time time;

	public void setUid(int uid){
		this.uid = uid;
	}

	public int getUid(){
		return uid;
	}

	public void setAqi(String aqi){
		this.aqi = aqi;
	}

	public String getAqi(){
		return aqi;
	}

	public void setStation(Station station){
		this.station = station;
	}

	public Station getStation(){
		return station;
	}

	public void setTime(Time time){
		this.time = time;
	}

	public Time getTime(){
		return time;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"uid = '" + uid + '\'' + 
			",aqi = '" + aqi + '\'' + 
			",station = '" + station + '\'' + 
			",time = '" + time + '\'' + 
			"}";
		}
}