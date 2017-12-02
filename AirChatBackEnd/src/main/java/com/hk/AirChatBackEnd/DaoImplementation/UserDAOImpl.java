package com.hk.AirChatBackEnd.DaoImplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.AirChatBackEnd.Dao.UserDAO;
import com.hk.AirChatBackEnd.Models.Blog;
import com.hk.AirChatBackEnd.Models.User;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sF;
	@Autowired
	public UserDAOImpl(SessionFactory sF) {
		this.sF = sF;
	}
	
	@Transactional
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().save(user);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().update(user);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().delete(user);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
	@Override
	public boolean updateStatus(User user) {
		// TODO Auto-generated method stub
		try{
			user.setStatus("Online");
			sF.getCurrentSession().update(user);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		User user=(User)ssn.get(User.class,userId);
		ssn.close();
		return user;
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		List<User> userList=(List<User>)ssn.createQuery("from User").list();
		ssn.close();
		return userList;
		
	}
	
}
