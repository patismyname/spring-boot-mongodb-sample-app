package com.pattana.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Company")
public class Company {


    @Size(max=250)
	private String name;
	

    @Size(max=250)
	private String catchPhrase;	

    @Size(max=250)
	private String bs;
	

	
	
	public Company() {
		
	}
	
	public Company(String name, String catchPhrase, String bs) {
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs
				+ "]";
	}
}
