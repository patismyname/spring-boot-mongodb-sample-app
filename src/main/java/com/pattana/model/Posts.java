package com.pattana.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "posts")
public class Posts {

	@Transient
    public static final String SEQUENCE_NAME = "posts_sequence";
	
	@Id
	private long id;
	
	@NotBlank
	private String userId;
	

    @Size(max=250)
	private String title;	

    @Size(max=250)
	private String body;
	
	
	public Posts() {
		
	}
	
	public Posts(String userId, String title, String body) {
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userId=" + userId + ", title=" + title + ", body=" + body
				+ "]";
	}
}
