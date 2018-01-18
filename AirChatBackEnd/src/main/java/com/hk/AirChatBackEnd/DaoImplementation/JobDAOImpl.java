package com.hk.AirChatBackEnd.DaoImplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.AirChatBackEnd.Dao.JobDAO;
import com.hk.AirChatBackEnd.Models.Blog;
import com.hk.AirChatBackEnd.Models.Job;
@Repository("jobDao")
public class JobDAOImpl implements JobDAO
{
	@Autowired
	SessionFactory sF;
	
	
	@Autowired
	public JobDAOImpl(SessionFactory sF) {
		
		this.sF = sF;
	}



	@Transactional
	@Override
	public boolean addJob(Job job) {
		// TODO Auto-generated method stub
		System.out.println(job);
		// TODO Auto-generated method stub
		try
		{
			sF.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		return false;
		}
	
	}



	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		Session ssn=sF.openSession();
		List<Job> jobList=(List<Job>)ssn.createQuery("from Job").list();
		ssn.close();
		return jobList;
	}

}
