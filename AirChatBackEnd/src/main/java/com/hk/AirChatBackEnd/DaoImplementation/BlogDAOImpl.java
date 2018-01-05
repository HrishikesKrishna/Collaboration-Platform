package com.hk.AirChatBackEnd.DaoImplementation;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.AirChatBackEnd.Dao.BlogDAO;
import com.hk.AirChatBackEnd.Models.Blog;
@Repository("blogDao")
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	SessionFactory sF;
	@Autowired
	public BlogDAOImpl(SessionFactory sF) {
		
		this.sF = sF;
	}

	@Transactional
	//@Override
	public boolean addBlog(Blog blog) {
		System.out.println(blog);
		// TODO Auto-generated method stub
		try
		{
			sF.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		return false;
		}
	}
	
	
	
	@Transactional
	//@Override
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		try
		{
			sF.getCurrentSession().update(blog);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	@Transactional
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
		{
			sF.getCurrentSession().delete(blog);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@Transactional
	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		Blog blog=(Blog)ssn.get(Blog.class, blogId);
		ssn.close();
		return blog;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		List<Blog> blogList=(List<Blog>)ssn.createQuery("from Blog").list();
		ssn.close();
		return blogList;
	}

	@Transactional
	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
			blog.setStatus("approved");
			sF.getCurrentSession().save(blog);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
	@Override
	public boolean rejectBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
			blog.setStatus("rejected");
			sF.getCurrentSession().save(blog);
			return true;
		}catch(Exception e){
		return false;
		}
	}

}
