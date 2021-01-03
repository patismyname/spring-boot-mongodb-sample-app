package com.pattana.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Course")
public class Course {

	@Transient
    public static final String SEQUENCE_NAME = "courses_sequence";
	
	@Id
	private long id;
		
	@NotBlank
    @Size(max=250)
	private String courseName;
	
    @Size(max=250)
	private String groupType;
	
	@Size(max=100)
	private String titleName;
	
	@Size(max=250)
	private String adsWord;
	
	@Size(max=1000)
	private String description;

	private int hoursTotalNum;
	
	private double costOfflineBht;	

	private Date startOfflineDate;	

	private Date finishOfflineDate;
	
	private String startOfflineTime;
	private String finishOfflineTime;
	
	private double costOnlineBht;
	
	private Date startOnlineDate;
	
	private Date finishOnlineDate;
	
	private String startOnlineTime;
	private String finishOnlineTime;
	
	private String vdoUrl;

	private String imageUrl;

	private Date createdDate;

	private Date updatedDate;
	
	@Size(max=50)
	private String createdBy;	
		
	@Size(max=50)
	private String updatedBy;
	
	@Size(max=10)
	private String status;	
		
	private String remarks;
	
	private String instructorName;
	private String instructorImgUrl;
	
	private int seqSec;
	
	public Course() {
		
	}
	
	public Course(String courseName, String groupType, String titleName) {
		this.courseName = courseName;
		this.groupType = groupType;
		this.titleName = titleName;
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
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	 * @return the adsWord
	 */
	public String getAdsWord() {
		return adsWord;
	}

	/**
	 * @param adsWord the adsWord to set
	 */
	public void setAdsWord(String adsWord) {
		this.adsWord = adsWord;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the hoursTotalNum
	 */
	public int getHoursTotalNum() {
		return hoursTotalNum;
	}

	/**
	 * @param hoursTotalNum the hoursTotalNum to set
	 */
	public void setHoursTotalNum(int hoursTotalNum) {
		this.hoursTotalNum = hoursTotalNum;
	}

	/**
	 * @return the costOfflineBht
	 */
	public double getCostOfflineBht() {
		return costOfflineBht;
	}

	/**
	 * @param costOfflineBht the costOfflineBht to set
	 */
	public void setCostOfflineBht(double costOfflineBht) {
		this.costOfflineBht = costOfflineBht;
	}

	/**
	 * @return the startOfflineDate
	 */
	public Date getStartOfflineDate() {
		return startOfflineDate;
	}

	/**
	 * @param startOfflineDate the startOfflineDate to set
	 */
	public void setStartOfflineDate(Date startOfflineDate) {
		this.startOfflineDate = startOfflineDate;
	}

	/**
	 * @return the finishOfflineDate
	 */
	public Date getFinishOfflineDate() {
		return finishOfflineDate;
	}

	/**
	 * @param finishOfflineDate the finishOfflineDate to set
	 */
	public void setFinishOfflineDate(Date finishOfflineDate) {
		this.finishOfflineDate = finishOfflineDate;
	}





	/**
	 * @return the costOnlineBht
	 */
	public double getCostOnlineBht() {
		return costOnlineBht;
	}

	/**
	 * @param costOnlineBht the costOnlineBht to set
	 */
	public void setCostOnlineBht(double costOnlineBht) {
		this.costOnlineBht = costOnlineBht;
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
	 * @return the startOfflineTime
	 */
	public String getStartOfflineTime() {
		return startOfflineTime;
	}

	/**
	 * @param startOfflineTime the startOfflineTime to set
	 */
	public void setStartOfflineTime(String startOfflineTime) {
		this.startOfflineTime = startOfflineTime;
	}

	/**
	 * @return the finishOfflineTime
	 */
	public String getFinishOfflineTime() {
		return finishOfflineTime;
	}

	/**
	 * @param finishOfflineTime the finishOfflineTime to set
	 */
	public void setFinishOfflineTime(String finishOfflineTime) {
		this.finishOfflineTime = finishOfflineTime;
	}

	/**
	 * @return the startOnlineTime
	 */
	public String getStartOnlineTime() {
		return startOnlineTime;
	}

	/**
	 * @param startOnlineTime the startOnlineTime to set
	 */
	public void setStartOnlineTime(String startOnlineTime) {
		this.startOnlineTime = startOnlineTime;
	}

	/**
	 * @return the finishOnlineTime
	 */
	public String getFinishOnlineTime() {
		return finishOnlineTime;
	}

	/**
	 * @param finishOnlineTime the finishOnlineTime to set
	 */
	public void setFinishOnlineTime(String finishOnlineTime) {
		this.finishOnlineTime = finishOnlineTime;
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

	/**
	 * @return the instructorName
	 */
	public String getInstructorName() {
		return instructorName;
	}

	/**
	 * @param instructorName the instructorName to set
	 */
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	/**
	 * @return the instructorImgUrl
	 */
	public String getInstructorImgUrl() {
		return instructorImgUrl;
	}

	/**
	 * @param instructorImgUrl the instructorImgUrl to set
	 */
	public void setInstructorImgUrl(String instructorImgUrl) {
		this.instructorImgUrl = instructorImgUrl;
	}
	
	

	/**
	 * @return the seqSec
	 */
	public int getSeqSec() {
		return seqSec;
	}

	/**
	 * @param seqSec the seqSec to set
	 */
	public void setSeqSec(int seqSec) {
		this.seqSec = seqSec;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", groupType=" + groupType + ", titleName=" + titleName
				+ "]";
	}	
}
