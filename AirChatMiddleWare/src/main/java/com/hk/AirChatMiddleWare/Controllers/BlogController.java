package com.hk.AirChatMiddleWare.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.AirChatBackEnd.Dao.BlogDAO;
import com.hk.AirChatBackEnd.Models.Blog;
import com.hk.AirChatBackEnd.Models.BlogComment;
import com.hk.AirChatBackEnd.Models.Forum;
import com.hk.AirChatBackEnd.Util.Date_Time;

@RestController
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	BlogDAO blogDAO;
	
	@PostMapping(value="/insertBlog")
	public ResponseEntity<String> insertBlog(@RequestBody Blog blog)
	{
		blog.setCreateddate(new java.util.Date());
		System.out.println("Blog : "+blog);
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog Added Succesfully"+blog,HttpStatus.OK);
		}
		else{
		return new ResponseEntity<String>("Blog Not Added....",HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping(value="/deleteblog/{bid}")
	public ResponseEntity<String> deleteBlog(@PathVariable("bid")int blogid)
	{
		Blog tempblog=blogDAO.getBlog(blogid);
		if(blogDAO.deleteBlog(tempblog)){
			return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("Blog Not Deleted",HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping(value="/approveBlog/{bid}")	
	public ResponseEntity<String> approveBlog(@PathVariable("bid")int blogid)
	{
		Blog tempblog=blogDAO.getBlog(blogid);
		 tempblog.setStatus("A");
		 boolean isSaved=blogDAO.updateBlog(tempblog);
		 if(isSaved)
		 {
			 return new ResponseEntity<String>("Blog approved",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Blog not approved",HttpStatus.BAD_REQUEST);
			}
	}
	@GetMapping(value="/rejectBlog/{bid}")
	public ResponseEntity<String> rejectBlog(@PathVariable("bid")int blogid)
	{
		Blog tempblog=blogDAO.getBlog(blogid);
		tempblog.setStatus("R");
		 boolean isSaved=blogDAO.updateBlog(tempblog);
		 if(isSaved)
		 {
			 return new ResponseEntity<String>("Blog rejected",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Blog not rejected",HttpStatus.BAD_REQUEST);
			}
	}
	
	@GetMapping(value="/getBlog/{bid}")
	public ResponseEntity<Blog> getBlog(@PathVariable("bid")int blogid)
	{
		Blog tempblog=blogDAO.getBlog(blogid);
		if(tempblog==null)
		{
			return new ResponseEntity<Blog>(tempblog,HttpStatus.BAD_REQUEST);
		}
		else
		{
			return new ResponseEntity<Blog>(tempblog,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getAllBlogs")
	public ResponseEntity<List<Blog>> getAllBlogs(){
		List<Blog> blogl=(List<Blog>)blogDAO.getAllBlogs();
		return new ResponseEntity<List<Blog>>(blogl,HttpStatus.OK);
	}
	
	@GetMapping(value="/insertBlogComment/{blogid}/{emailId}/{comment}")
	public ResponseEntity<String> addBlogComment(@PathVariable("blogid")int blogid,@PathVariable("emailId")String emailId,@PathVariable("comment")String comment)
	{
		System.out.println(blogid+emailId+comment);
		BlogComment bc=new BlogComment();
		bc.setBlogID(blogid);
		bc.setUserName(emailId);
		bc.setComment(comment);
		Date_Time dt=new Date_Time();
		String date=dt.getDateTime();
		bc.setCommentDate(date);
		boolean isSaved=blogDAO.addBlogComment(bc);
		if(isSaved){
			return new ResponseEntity<String>("BlogComment added succesfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in adding blog comment",HttpStatus.BAD_REQUEST);
		}
	
	}
	@GetMapping(value="/getBlogComments/{blogid}")
	public ResponseEntity<List<BlogComment>> getBlogComments(@PathVariable("blogid")int blogid){
		System.out.println("Getting Blog Comments Check");
		List<BlogComment> blogc=(List<BlogComment>)blogDAO.getAllBlogComments(blogid);
		System.out.println("Getting Blog Comments");
		System.out.println(blogc);
		if(blogc.isEmpty()){
			return null;
		}
		else
		{
		return new ResponseEntity<List<BlogComment>>(blogc,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getBlogReq")
	public List<Blog> getBlogReq(){
	 System.out.println("Fetching Blog Req");
		List<Blog> blogreq=(List<Blog>)blogDAO.blogRequest();
		System.out.println("Forum Req");
		return blogreq;		
} 
	
	
}
