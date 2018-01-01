	package com.hk.AirChatBackEnd.Models;

	import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

	@Entity
	@Component	
	@Table(name="Blog")
	public class Blog   {

		/**
		 * 
		 */
 		
		 
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE)
 		private int blogid;
		@Column(name = "Blogname", nullable = false)
	    private String blogname;
		@Column(name = "BlogContent", nullable = false)
	    private String blogcontent;
		@Column(name = "Username", nullable = false)
	    private String username;
		@Column(name="CreatedDate",nullable=false)
		private Date createddate;
		@Column(name = "Status", nullable = false)
	    private String status;
		@Column(name = "Likes", nullable = false)
	    private int likes;
			
		 
		public int getBlogid() {
			return blogid;
		}
		public void setBlogid(int blogid) {
			this.blogid = blogid;
		}
		public String getBlogname() {
			return blogname;
		}
		public void setBlogname(String blogname) {
			this.blogname = blogname;
		}
		public String getBlogcontent() {
			return blogcontent;
		}
		public void setBlogcontent(String blogcontent) {
			this.blogcontent = blogcontent;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public Date getCreateddate() {
			return createddate;
		}
		public void setCreateddate(Date createddate) {
			this.createddate = createddate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getLikes() {
			return likes;
		}
		public void setLikes(int likes) {
			this.likes = likes;
		}
		

	}