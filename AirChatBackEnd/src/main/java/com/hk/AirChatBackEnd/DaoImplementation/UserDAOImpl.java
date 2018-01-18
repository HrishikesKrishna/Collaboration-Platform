package com.hk.AirChatBackEnd.DaoImplementation;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.AirChatBackEnd.Dao.UserDAO;
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
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		List<User> userList=(List<User>)ssn.createQuery("from User").list();
		ssn.close();
		return userList;
	}

	@Override
	public boolean login(User user) 
	{
		// TODO Auto-generated method stub
		try
		{
			Session ssn=sF.openSession();
			Query query=ssn.createQuery("from User where (emailId='"+user.getEmailId()+"'and password='"+user.getPassword()+"') and (status='A')");
			
		List<User> usr=(List<User>)query.list();
		if(usr.isEmpty())
		{
			System.out.println("Invalid user");
			return false;
		}
		else
		{
			System.out.println("Valid User");
			return true;
		}
		}
		catch(Exception e){
			{
				System.out.println(" Exception inValid User"+e.getMessage());
				return false;
			}
	}
	}

	@Override
	public User getUserbyemailId(String emailId) {
		// TODO Auto-generated method stub
		User user=new User();
		try
		{
			Session ssn=sF.openSession();
			Query query=ssn.createQuery("from User where emailId='"+emailId+"'");
			user=(User)query.list().get(0);
			ssn.close();
		}
		catch(Exception e)
		{
			System.out.println("inValid User exception"+e.getMessage());
		}
		return user;
	}

	
	@Override
	public boolean logincheck(User user) {
		// TODO Auto-generated method stub
		try
		{
			Session ssn=sF.openSession();
			Query query=ssn.createQuery("from User where emailId='"+user.getEmailId()+"'and password='"+user.getPassword()+"'");

		List<User> usr=(List<User>)query.list();
		if(usr.isEmpty())
		{
			System.out.println("Invalid user");
			return false;
		}
		else
		{
			System.out.println("Valid User");
			return true;
		}
		}
		catch(Exception e){
			{
				System.out.println("Exception inValid User"+e.getMessage());
				return false;
			}
	}

	
	}

	@Override
	public boolean emailCheck(User user) {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		Query query=ssn.createQuery("from User where emailId='"+user.getEmailId()+"'");
		List<User> usr=(List<User>)query.list();
		if(usr.isEmpty())
		{	
			return false;
		}
		else
		{
			return true;
		}
	}
	@Transactional
	@Override
	public List<User> userrequest() {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		List<User> userreq=(List<User>)ssn.createQuery("from User where status='P'").list();
		ssn.close();
		return userreq;
	}

	@Override
	public boolean approveUser(User user) {
		// TODO Auto-generated method stub
		try {
	  		sF.getCurrentSession().saveOrUpdate(user);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	}
	}

	@Override
	public boolean rejectUser(User user) {
		// TODO Auto-generated method stub
		try {
	  		sF.getCurrentSession().saveOrUpdate(user);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	}
	}

	@Override
	public boolean saveorupdateUser(User user) {
		// TODO Auto-generated method stub
		try
		{
			sF.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	
	
	

	
	
}
