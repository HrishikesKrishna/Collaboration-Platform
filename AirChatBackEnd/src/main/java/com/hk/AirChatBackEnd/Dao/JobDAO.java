package com.hk.AirChatBackEnd.Dao;

import java.util.List;

import com.hk.AirChatBackEnd.Models.Job;

public interface JobDAO {
	public boolean addJob(Job job);

	public List<Job> getAllJobs();
}
