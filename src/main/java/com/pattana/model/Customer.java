package com.pattana.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Customer")
public class Customer {

	@Transient
    public static final String SEQUENCE_NAME = "customers_sequence";
	
	@Id
	private long id;
	
	@NotBlank
    @Size(max=250)
	private String firstName;
	private String lastName;	

    @Size(max=13)
	private String idCard;
	
	@NotBlank
    @Size(max=250)
	private String emailId;
	
	@Size(max=100)
	private String title;
	
	@Size(max=250)
	private String thaiName;
	
	@Size(max=250)
	private String thaiLastName;
	
	@Size(max=100)
	private String nickName;
	
	@Size(max=100)
	private String middleName;

	private Date birthDate;
	
    @Size(max=4)
	private String birthYear;	

    @Size(max=2)
	private String country;	

    @Size(max=10)
	private String mobile;	

    @Size(max=50)
	private String groupType;
	
	@Size(max=100)
	private String imageUrl;	

	private Date createdDate;	

	private Date updatedDate;
	
	@Size(max=50)
	private String createdBy;	
		
	@Size(max=50)
	private String updatedBy;
	
	@NotBlank
	@Size(max=10)
	private String status;	
		
	@Size(max=250)
	private String remarks;	
	
	private Address address;

	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThaiName() {
		return thaiName;
	}

	public void setThaiName(String thaiName) {
		this.thaiName = thaiName;
	}

	public String getThaiLastName() {
		return thaiLastName;
	}

	public void setThaiLastName(String thaiLastName) {
		this.thaiLastName = thaiLastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}



	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}	
}
