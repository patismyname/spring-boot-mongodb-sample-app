package com.pattana.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "geo")
public class Geo {


    @Size(max=250)
	private String lat;
	

    @Size(max=250)
	private String lng;	

   

	
	public Geo() {
		
	}
	
	public Geo(String lat, String lng) {
		this.lat = lat;
		this.lng = lng;

	}


	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Customer [lat=" + lat + ", lat=" + lat + ", lng=" + lng + "]";
	}
}
