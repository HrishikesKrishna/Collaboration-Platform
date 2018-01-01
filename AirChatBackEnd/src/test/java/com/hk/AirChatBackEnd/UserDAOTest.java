package com.hk.AirChatBackEnd;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hk.AirChatBackEnd.Dao.UserDAO;
import com.hk.AirChatBackEnd.Models.User;

public class UserDAOTest {
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.hk.AirChatBackEnd");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDao");
	} 
	@Ignore
	@Test
	public void addUserTest() {
		User user=new User();
		user.setFirstName("HK");
		user.setLastName("Krishna");
		user.setIsOnline("Y");
		user.setEmailId("hk@gmail.com");
		user.setPassword("LasVenturas");
		user.setRole("User");
		user.setStatus("happy");
		assertTrue("Problem in inserting User",userDAO.addUser(user));
	}
	
	@Ignore
	@Test
	public void updateUsertTest()
	{
		User user=new User();
		user.setFirstName("HK");
		user.setLastName("Krishna");
		user.setIsOnline("Y");
		user.setEmailId("hk@gmail.com");
		user.setPassword("LasVenturas");
		user.setRole("User");
		user.setStatus("happy");
		assertTrue("Problem in updating User",userDAO.updateUser(user));
	}
	
	@Ignore
	@Test
	public void updateStatusTest()
	{
		User user =new User();
		user.setStatus("Good");
		assertTrue("Problem in updating Status",userDAO.updateStatus(user));
	}
	
	@Ignore
	@Test
	public void getUserTest()
	{
		User user=userDAO.getUser(45);
		System.out.println(user.getFirstName());
		System.out.println(user.getEmailId());
	}
	
	@Ignore
	@Test
	public void getAllUsersTest()
	{
		List<User> user=(List<User>)userDAO.getAllUsers();
		for(User u:user)
		{
			System.out.println(u.getFirstName());
		}
	}
	
	@Ignore
	@Test
	public void deleteUserTest()
	{
		User user=(User)userDAO.getUser(10);
		assertTrue("Problem in deleting User",userDAO.deleteUser(user));
	}
}
