package com.hk.AirChatBackEnd.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="FORUMCOMMENT")
public class ForumComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FORUMCOMMENTID",nullable=false)
	private int id;
	@Column(name="FORUMID",nullable=false)
	private String forumId;
	@Column(name="FORUMCOMMENT",nullable=false)
	private String forumcomment;
	@Column(name="COMMENTDATE",nullable=false)
	private Date commentDate;
	@Column(name="USERID",nullable=false)
	private String userID;
	@Column(name="USERNAME",nullable=false)
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getForumId() {
		return forumId;
	}
	public void setForumId(String forumId) {
		this.forumId = forumId;
	}
	public String getForumcomment() {
		return forumcomment;
	}
	public void setForumcomment(String forumcomment) {
		this.forumcomment = forumcomment;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
