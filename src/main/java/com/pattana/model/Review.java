package com.pattana.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Reviewed")
public class Review {

	@Transient
    public static final String SEQUENCE_NAME = "reviewedes_sequence";
	
	@Id
	private long id;		
	
    @Size(max=250)
	private String groupType;
	
    private int titleId;	
    
	@Size(max=100)
	private String titleName;
		
	@Size(max=1000)
	private String comments;	
	
	private String vdoUrl;

	private String imageUrl;

	private Date reviewedDate;

	private int userId;	
	
	@Size(max=50)
	private String reviewedBy;	
		
	@Size(max=50)
	private String updatedBy;
	
	@Size(max=10)
	private String status;	
		
	private String remarks;
	
	private int starMarks;
	
	public Review() {
		
	}
	
	public Review(String titleName, String groupType, String comments) {
		this.titleName = titleName;
		this.groupType = groupType;
		this.comments = comments;
	}
	
	

	/**
	 * @return the groupType
	 */
	public String getGroupType() {
		return groupType;
	}

	/**
	 * @param groupType the groupType to set
	 */
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	
	/**
	 * @return the titleId
	 */
	public int getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId the titleId to set
	 */
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	/**
	 * @return the titleName
	 */
	public String getTitleName() {
		return titleName;
	}

	/**
	 * @param titleName the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the vdoUrl
	 */
	public String getVdoUrl() {
		return vdoUrl;
	}

	/**
	 * @param vdoUrl the vdoUrl to set
	 */
	public void setVdoUrl(String vdoUrl) {
		this.vdoUrl = vdoUrl;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the reviewedDate
	 */
	public Date getReviewedDate() {
		return reviewedDate;
	}

	/**
	 * @param reviewedDate the reviewedDate to set
	 */
	public void setReviewedDate(Date reviewedDate) {
		this.reviewedDate = reviewedDate;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the reviewedBy
	 */
	public String getReviewedBy() {
		return reviewedBy;
	}

	/**
	 * @param reviewedBy the reviewedBy to set
	 */
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the starMarks
	 */
	public int getStarMarks() {
		return starMarks;
	}

	/**
	 * @param starMarks the starMarks to set
	 */
	public void setStarMarks(int starMarks) {
		this.starMarks = starMarks;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", titleName=" + titleName + ", groupType=" + groupType + ", comments=" + comments
				+ "]";
	}	
}
