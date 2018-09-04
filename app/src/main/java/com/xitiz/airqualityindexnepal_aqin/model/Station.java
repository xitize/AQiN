package com.xitiz.airqualityindexnepal_aqin.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Station{

	@SerializedName("geo")
	private List<Double> geo;

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public void setGeo(List<Double> geo){
		this.geo = geo;
	}

	public List<Double> getGeo(){
		return geo;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Station{" + 
			"geo = '" + geo + '\'' + 
			",name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}