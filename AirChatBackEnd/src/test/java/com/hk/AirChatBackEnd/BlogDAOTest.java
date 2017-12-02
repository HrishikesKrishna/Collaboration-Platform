package com.hk.AirChatBackEnd;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hk.AirChatBackEnd.Dao.*;
import com.hk.AirChatBackEnd.Models.Blog;

import junit.framework.TestCase;

import static org.junit.Assert.*;
import java.sql.Date.*;
import java.util.*;
public class BlogDAOTest 
{
	@Autowired
private static BlogDAO blogDAO;
	
	
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.hk.AirChatBackEnd");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDao");
	}

	
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
 		blog.setBlogname("abcd");
		blog.setBlogcontent("hrishi");
		blog.setUsername("krishna");
		blog.setStatus("Online");
		blog.setLikes(8);
		blog.setDislikes(8);
		
		
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	
	}
	
	
	
	
	@Ignore
	@Test
	public void getblogTest()
	{
		
		Blog blog=blogDAO.getBlog(41);
		System.out.println(blog.getBlogcontent());
		System.out.println(blog.getBlogname());
	}
	
	
	
	
@Ignore
	@Test
	public void updateBlogTest()
	{
		
		Blog blog=(Blog)blogDAO.getBlog(43);
		blog.setBlogcontent("it is hibernate based");
		blog.setBlogname("hibernate core");
		assertTrue("Problem in Updating  Blog",blogDAO.updateBlog(blog));
		
		
	}
	
	
	
	
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(45);
		assertTrue("Problem in Updating  Blog",blogDAO.deleteBlog(blog));
		
		
		
	}
	
	
	
	
	@Ignore
	@Test
	public void getAllBlogTest()
	{
		
	
		ArrayList<Blog> blog=(ArrayList<Blog>)blogDAO.getAllBlogs();
	for(Blog b:blog)
	{
		System.out.println(b.getBlogname());
	}
	
	}
	
	
	
	
    @Ignore
	@Test
	public void approveBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(43);
		blog.setStatus("Y");
		assertTrue("Problem in Approving  Blog",blogDAO.approveBlog(blog));
		
	}
	
	
	
	
	 
	
	
}
