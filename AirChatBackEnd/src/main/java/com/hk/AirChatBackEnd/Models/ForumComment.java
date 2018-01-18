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
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "SEQUENCE_NAME")
	@SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
	@Column(name="FORUMCOMMENTID",nullable=false)
	private int id;
	@Column(name="FORUMID",nullable=false)
	private int forumId;
	@Column(name="FORUMCOMMENT",nullable=false)
	private String forumcomment;
	@Column(name="COMMENTDATE",nullable=false)
	private String commentDate;
	@Column(name="USERNAME",nullable=false)
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getForumcomment() {
		return forumcomment;
	}
	public void setForumcomment(String forumcomment) {
		this.forumcomment = forumcomment;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
