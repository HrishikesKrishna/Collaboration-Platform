package com.hk.AirChatBackEnd;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hk.AirChatBackEnd.Dao.ForumDAO;
import com.hk.AirChatBackEnd.Models.Blog;
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
	
	
	@Test
	public void addForumTest() {
		Forum forum=new Forum();
		//forum.setForumId(8);
		forum.setForumName("HK's Forum");
		forum.setCreatedDate(new Date());
		forum.setForumContent("About Hydrogen");
		forum.setStatus("Excited");
		forum.setUserId(10);
		assertTrue("Problem in adding Forum",forumDAO.addForum(forum));
	}
	@Ignore
	@Test
	public void updateForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(43);
		forum.setForumContent("Bamboo");
		forum.setForumName("Giant Panda");
		assertTrue("Problem in Updating  Forum",forumDAO.updateForum(forum));	
	}
	
	@Ignore
	@Test
	public void deleteForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(40);
		assertTrue("Problem in deleting Forum",forumDAO.deleteForum(forum));	
	}
	
	@Ignore
	@Test
	public void getForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(44);
		System.out.println(forum.getForumContent());
		System.out.println(forum.getForumName());
	}
	
	@Ignore
	@Test
	public void getAllForumTest()
	{
		List<Forum> forum=(List<Forum>)forumDAO.getAllForums();
		for(Forum f:forum)
		{
			System.out.println(f.getForumContent());
		}
	}
	
	@Ignore
	@Test
	public void approveForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(11);
		forum.setStatus("A");
		assertTrue("Problem in Approving  Forum",forumDAO.approveForum(forum));
	}
	
	@Ignore
	@Test
	public void rejectForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(42);
		forum.setStatus("R");
		assertTrue("Problem in Rejecting  Forum",forumDAO.rejectForum(forum));
		
	}
}