package com.hk.AirChatMiddleWare.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.AirChatBackEnd.Dao.JobDAO;
import com.hk.AirChatBackEnd.Models.Blog;
import com.hk.AirChatBackEnd.Models.Job;

@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
	JobDAO jobdao;
	
	@PostMapping(value="/addJob")
	public ResponseEntity<String> addJob(@RequestBody Job job)
	{
		
		job.setPostDate(new java.util.Date());
		System.out.println("Job : "+job);
		if(jobdao.addJob(job))
		{
			return new ResponseEntity<String>("Job Added Succesfully"+job,HttpStatus.OK);
		}
		else{
		return new ResponseEntity<String>("Job Not Added....",HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping(value="/getAllJobs")
	public ResponseEntity<List<Job>> getAllJobs(){
		List<Job> jobl=(List<Job>)jobdao.getAllJobs();
		return new ResponseEntity<List<Job>>(jobl,HttpStatus.OK);
	}
}
