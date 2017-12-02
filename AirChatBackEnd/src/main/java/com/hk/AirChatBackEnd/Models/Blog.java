	package com.hk.AirChatBackEnd.Models;

	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

	@Entity
	@Component	
	@Table(name="Blog")
	public class Blog   {

		/**
		 * 
		 */
 		
		 
		@Id
		@GeneratedValue
		@Column(name = "BlogID")
		private String blogid;
		public String getBlogid() {
			return blogid;
		}
		public void setBlogid(String blogid) {
			this.blogid = blogid;
		}
		@Column(name = "Blogname", nullable = false)
	    private String blogname;
		@Column(name = "BlogContent", nullable = false)
	    private String blogcontent;
		@Column(name = "Username", nullable = false)
	    private String username;
		@Column(name = "Status", nullable = false)
	    private String status;
		@Column(name = "Likes", nullable = false)
	    private int likes;
		@Column(name = "Dislikes", nullable = false)
	    private int dislikes;
		
		public int getDislikes() {
			return dislikes;
		}
		public void setDislikes(int dislikes) {
			this.dislikes = dislikes;
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