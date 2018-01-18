package com.hk.AirChatBackEnd.DaoImplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.AirChatBackEnd.Dao.ForumDAO;
import com.hk.AirChatBackEnd.Models.Blog;
import com.hk.AirChatBackEnd.Models.BlogComment;
import com.hk.AirChatBackEnd.Models.Forum;
import com.hk.AirChatBackEnd.Models.ForumComment;
import com.hk.AirChatBackEnd.Models.User;

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
	public Forum getForum(int forumId) {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		Forum forum=(Forum)ssn.get(Forum.class, forumId);
		ssn.close();
		return forum;
	}
	
	@Transactional
	@Override
	public List<Forum> getAllForums() {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		List<Forum> forumList=(List<Forum>)ssn.createQuery("from Forum where status='A'").list();
		ssn.close();
		return forumList;
	}
	
	@Transactional
	@Override
	public boolean approveForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
			forum.setStatus("A");
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
			forum.setStatus("R");
			sF.getCurrentSession().save(forum);
			return true;
		}catch(Exception e){
		return false;
		}
	}

	@Override
	public List<Forum> forumRequest() {
		// TODO Auto-generated method stub
		Session ssn = sF.openSession();
		List<Forum> forumreq=(List<Forum>)ssn.createQuery("from Forum where status='P'").list();
		ssn.close();
	return forumreq; 
	}
	
	@Transactional
	@Override
	public boolean addForumComment(ForumComment forumcomment) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().save(forumcomment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<ForumComment> getAllForumComments(int forumId) {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		org.hibernate.Query q=ssn.createQuery("from ForumComment where forumId="+forumId);
		List<ForumComment> list=(List<ForumComment>)q.list();
		ssn.close();
		return list;
	}
	
	
}
