package com.hk.AirChatBackEnd.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="FORUM")
public class Forum implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "SEQUENCE_NAME")
@SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
@Column(name="ForumID",nullable=false)
private int forumId;
@Column(name="ForumName",nullable=false)
private String forumName;
@Column(name="ForumContent",nullable=false)
private String forumContent;
@Column(name="UserName",nullable=false)
private String userName;
@Column(name="CreatedDate",nullable=false)
private Date createdDate;
@Column(name="Status",nullable=false)
private String status;



public int getForumId() {
	return forumId;
}
public void setForumId(int forumId) {
	this.forumId = forumId;
}
public String getForumName() {
	return forumName;
}
public void setForumName(String forumName) {
	this.forumName = forumName;
}
public String getForumContent() {
	return forumContent;
}
public void setForumContent(String forumContent) {
	this.forumContent = forumContent;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}



}
