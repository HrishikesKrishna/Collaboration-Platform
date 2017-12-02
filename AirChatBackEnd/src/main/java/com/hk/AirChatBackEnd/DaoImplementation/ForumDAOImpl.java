package com.hk.AirChatBackEnd.DaoImplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.AirChatBackEnd.Dao.ForumDAO;
import com.hk.AirChatBackEnd.Models.Forum;

@Repository("forumDao")
public class ForumDAOImpl implements ForumDAO {
	@Autowired
	SessionFactory sF;
	@Autowired
	public ForumDAOImpl(SessionFactory sF) {
		this.sF = sF;
	}
	
	@Transactional
	@Override
	public boolean addForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().save(forum);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
	@Override
	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().update(forum);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
	@Override
	public boolean deleteForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().delete(forum);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
	@Override
	public Forum getForum(int forumId) {
		// TODO Auto-generated method stub
			Session ssn=sF.openSession();
			Forum forum=(Forum)ssn.get(Forum.class,forumId);
			ssn.close();
			return forum;
	}
	
	@Transactional
	@Override
	public List<Forum> getAllForums() {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		List<Forum> forumList=(List<Forum>)ssn.createQuery("from Forum").list();
		ssn.close();
		return forumList;
	}
	
	@Transactional
	@Override
	public boolean approveForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
			forum.setStatus("approved");
			sF.getCurrentSession().save(forum);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
	@Override
	public boolean rejectForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
			forum.setStatus("rejected");
			sF.getCurrentSession().save(forum);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
}
