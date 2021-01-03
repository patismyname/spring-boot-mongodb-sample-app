package com.pattana.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Address")
public class Address {

	private String homeNo;	

	private String homefloor;	
    
    @Size(max=250)
	private String street;    

	private String soi;	
    
    @Size(max=250)
	private String village;	    

    @Size(max=250)
	private String district;
    
    @Size(max=250)
	private String amphoe;
    
    @Size(max=250)
	private String province;
	
	@Size(max=5)
	private String zipcode;	

	private Geo geo;	
	
	public Address() {
		
	}
	
	public Address(String homeNo, String homefloor, String village) {
		this.street = homeNo;
		this.homefloor = homefloor;
		this.village = village;
	}
	
	


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}	

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	
	
	

	public String getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}

	public String getHomefloor() {
		return homefloor;
	}

	public void setHomefloor(String homefloor) {
		this.homefloor = homefloor;
	}

	public String getSoi() {
		return soi;
	}

	public void setSoi(String soi) {
		this.soi = soi;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAmphoe() {
		return amphoe;
	}

	public void setAmphoe(String amphoe) {
		this.amphoe = amphoe;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Customer [zipcode=" + zipcode + ", street=" + street + ", homefloor=" + homefloor + ", homeNo=" + homeNo
				+ "]";
	}
}
