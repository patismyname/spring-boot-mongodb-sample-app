package com.pattana.model;

import java.util.Date;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
public class Image {
    
    @Id
    private String id;    
    private String topic;        
    //private Binary image;    
    private String thumbnailUrl;    
    private String albumId;    
    private String url;    
    private String name; 
    private String contentType;
    private long size;
    private Date uploadDate;
    private String md5;
   // private Binary content; 
    private String path;
    private String groupType;
    private String status;
    private String desc;
    private String createdBy;
    private int seqSec;
    

    public Image(String topic) {
        super();
        this.topic = topic;
    }
    

    public Image() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }





	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}


	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public long getSize() {
		return size;
	}


	public void setSize(long size) {
		this.size = size;
	}


	public Date getUploadDate() {
		return uploadDate;
	}


	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}


	public String getMd5() {
		return md5;
	}


	public void setMd5(String md5) {
		this.md5 = md5;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getGroupType() {
		return groupType;
	}


	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getThumbnailUrl() {
		return thumbnailUrl;
	}


	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}


	public String getAlbumId() {
		return albumId;
	}


	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	
	public int getSeqSec() {
		return seqSec;
	}


	public void setSeqSec(int seqSec) {
		this.seqSec = seqSec;
	}


	@Override
    public String toString() {
        return "Photo [id=" + id + ", topic=" + topic + ", status=" + status + ", image=\" + imageUrl + \"]";
    }
    
}
