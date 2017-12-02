package com.hk.AirChatBackEnd;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hk.AirChatBackEnd.Dao.ForumDAO;
import com.hk.AirChatBackEnd.Models.Forum;

public class ForumDAOTest {
	@Autowired
	private static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.hk.AirChatBackEnd");
		context.refresh();
		
		forumDAO=(ForumDAO)context.getBean("forumDao");
	}
	
	@Ignore
	@Test
	public void addForumTest() {
		Forum forum=new Forum();
		forum.setForumId(8);
		forum.setForumName("HK's Forum");
		forum.setCreatedDate(new Date());
		forum.setForumContent("About Hydrogen");
		forum.setStatus("Excited");
		forum.setUserId(10);
		
		assertTrue("Problem in adding Forum",forumDAO.addForum(forum));
	}

}
