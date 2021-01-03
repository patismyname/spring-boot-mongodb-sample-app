package com.pattana.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "advertisement")
public class Advertisement {

	@Transient
    public static final String SEQUENCE_NAME = "advertisements_sequence";
	
	@Id
	private long id;
		
	@NotBlank
	private String topicTitle;
	
	private String msgDetails;
	
	private Date startOnlineDate;
	
	private Date finishOnlineDate;
	
	private String vdoUrl;

	private String imageUrl;
	
	private String groupType;

	private Date createdDate;

	private Date updatedDate;
	
	private String createdBy;	

	private String updatedBy;
	
	private String status;	
		
	private String remarks;
	

	
	public Advertisement() {
		
	}
	
	public Advertisement(String topicTitle, String msgDetails, String imageUrl) {
		this.topicTitle = topicTitle;
		this.msgDetails = msgDetails;
		this.imageUrl = imageUrl;
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

	
	

	/**
	 * @return the topicTitle
	 */
	public String getTopicTitle() {
		return topicTitle;
	}

	/**
	 * @param topicTitle the topicTitle to set
	 */
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	/**
	 * @return the msgDetails
	 */
	public String getMsgDetails() {
		return msgDetails;
	}

	/**
	 * @param msgDetails the msgDetails to set
	 */
	public void setMsgDetails(String msgDetails) {
		this.msgDetails = msgDetails;
	}

	/**
	 * @return the startOnlineDate
	 */
	public Date getStartOnlineDate() {
		return startOnlineDate;
	}

	/**
	 * @param startOnlineDate the startOnlineDate to set
	 */
	public void setStartOnlineDate(Date startOnlineDate) {
		this.startOnlineDate = startOnlineDate;
	}

	/**
	 * @return the finishOnlineDate
	 */
	public Date getFinishOnlineDate() {
		return finishOnlineDate;
	}

	/**
	 * @param finishOnlineDate the finishOnlineDate to set
	 */
	public void setFinishOnlineDate(Date finishOnlineDate) {
		this.finishOnlineDate = finishOnlineDate;
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
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", topicTitle=" + topicTitle + ", msgDetails=" + msgDetails + ", imageUrl=" + imageUrl
				+ "]";
	}	
}
