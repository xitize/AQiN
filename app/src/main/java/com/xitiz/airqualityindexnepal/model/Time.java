package com.xitiz.airqualityindexnepal.model;

import com.google.gson.annotations.SerializedName;

public class Time{

	@SerializedName("tz")
	private String tz;

	@SerializedName("vtime")
	private int vtime;

	@SerializedName("stime")
	private String stime;

	public void setTz(String tz){
		this.tz = tz;
	}

	public String getTz(){
		return tz;
	}

	public void setVtime(int vtime){
		this.vtime = vtime;
	}

	public int getVtime(){
		return vtime;
	}

	public void setStime(String stime){
		this.stime = stime;
	}

	public String getStime(){
		return stime;
	}

	@Override
 	public String toString(){
		return 
			"Time{" + 
			"tz = '" + tz + '\'' + 
			",vtime = '" + vtime + '\'' + 
			",stime = '" + stime + '\'' + 
			"}";
		}
}